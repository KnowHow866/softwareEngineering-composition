package textcomposition;

import java.util.ArrayList;

/**
 * Array composition.
 * @author group2
 * @since 0.0.1
 */
public class ArrayLineBreakStrategy implements LineBreakStrategy{
  /**
   * Compose components with strategy that selects breaks so that each row has a fixed number of
   * items.
   * Display 3 components in one line, split by space.
   * Display format of component: [[currentSize]][Content] e.g. [1]Hi
   * E.q.
   * [1]Hi [1]<ParagraphEnd> [1]nice
   * [1]to [1]meet [1]you
   * [1]scared.jpg [1]<ParagraphEnd>
   * @param components components.
   */
  @Override
  public void compose(ArrayList<Component> components){
    int amountPerRow = 3;
    String result = "";
    int i = 1;
    for(Component component: components){
      result += i % amountPerRow == 1 ? component : " " + component;
      if(i % amountPerRow == 0){
        result += "\n";
      }

      i++;
    }

    // If the last row is not full, add newline.
    if(i % amountPerRow != 1){
        result += "\n";
    }

    System.out.print(result);
  }
}
