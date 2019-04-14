import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.BufferedReader;

import textcomposition.Composition;
import textcomposition.Component;
import textcomposition.LineBreakStrategy;
import textcomposition.SimpleLineBreakStrategy;
import textcomposition.TexLineBreakStrategy;
import textcomposition.ArrayLineBreakStrategy;

/**
 * Main.
 * @author group2
 * @since 0.0.1
 */
public class Main{
  public static void main(String[] args){
    // Read input
    Path inputPath = null;
    String line = null;

    // Check arguments
    if(args.length != 1){
      System.out.println("[USAGE] java Main INPUT_FILE");
      System.exit(1);
    }

    String inputFile = args[0];

    // Execution
    Composition composition = new Composition();
    inputPath = Paths.get(inputFile);
    
    try(BufferedReader reader = Files.newBufferedReader(inputPath)){
      while((line = reader.readLine()) != null){
        String[] lineS = line.split(" ");
        switch(lineS[0]){
          case "Text":
          case "GraphicalElement":
            cmdCreateComponent(composition, line);
            break;
          case "ChangeSize":
            cmdChangeSize(composition, lineS[1], Integer.parseInt(lineS[2]));
            break;
          case "Require":
            cmdRequire(composition, lineS[1]);
            break;
        }
      }
    }catch(IOException e){
      System.out.println(String.format("Cannot read %s", inputFile));
      System.exit(1);
    }
  }

  /**
   * Command for creating component.
   * @param composition composition.
   * @param command command.
   */
  private static void cmdCreateComponent(Composition composition, String command){
    String[] commandS = command.split(" ");

    String componentId = commandS[1];
    int naturalSize = Integer.parseInt(commandS[2]);
    int shrinkability = Integer.parseInt(commandS[3]);
    int stretchability = Integer.parseInt(commandS[4]);
    String content = "";

    for(int i = 5 ; i < commandS.length ; i++){
      content += content.equals("") ? commandS[i] : " " + commandS[i];
    }

    composition.addComponent(new Component(componentId, naturalSize, stretchability, shrinkability, content));
  }

  /**
   * Command for changing size of component.
   * @param composition composition.
   * @param componentId component ID.
   * @param size size.
   */
  private static void cmdChangeSize(Composition composition, String componentId, int size){
    composition.changeComponentSize(componentId, size);
  }

  /**
   * Command for specifying linebreaking strategy and displaying.
   * @param composition composition.
   * @param breakStrategy linebreaking strategy.
   */
  private static void cmdRequire(Composition composition, String breakStrategy){
    LineBreakStrategy strategy = null;
    switch(breakStrategy){
      case "SimpleComposition":
        strategy = new SimpleLineBreakStrategy();
        break;
      case "TexComposition":
        strategy = new TexLineBreakStrategy();
        break;
      case "ArrayComposition":
        strategy = new ArrayLineBreakStrategy();
        break;
    }
    composition.setLineBreakStrategy(strategy);
    composition.compose();
  }
}
