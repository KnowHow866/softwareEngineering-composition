import java.util.ArrayList;

/**
 * Tex composition.
 * @author group2
 * @since 0.0.1
 */
public class TexLineBreakStrategy implements LineBreakStrategy{
  /**
   * Compose components with strategy that determines tries to optimize line breaks globally, that
   * is, one paragraph at a time.
   * Display all components before component with content <ParagraphEnd> in one line, split by space.
   * Display format of component: [[currentSize]][Content] e.g. [1]Hi
   * E.q.
   * [1]Hi [1]<ParagraphEnd>
   * [1]nice [1]to [1]meet [1]you [1]scared.jpg [1]<ParagraphEnd>
   * @param components components.
   */
  @Override
  public void compose(ArrayList<Component> components){
    String result = "";
    boolean newParagraph = true;
    for(Component component: components){
      if(newParagraph){

        result += component;
        newParagraph = false;
      }else{
        result += " " + component;
      }

      if(component.getContent().equals("<ParagraphEnd>")){
        result += "\n";
        newParagraph = true;
      }
    }

    // If the content of last component is not "<ParagraphEnd>", add newline.
    if(!newParagraph){
      result += "\n";
    }

    System.out.print(result);
  }
}
