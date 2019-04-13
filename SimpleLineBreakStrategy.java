import java.util.ArrayList;

/**
 * Simple composition.
 * @author group2
 * @since 0.0.1
 */
public class SimpleLineBreakStrategy implements LineBreakStrategy{
  /**
   * Compose components with strategy that determines line breaks one at a time.
   * Display display one component for each line.
   * Display format of component: [[currentSize]][Content] e.g. [1]Hi
   * E.q.
   * [1]Hi
   * [1]<ParagraphEnd>
   * [1]nice
   * @param components components.
   */
  @Override
  public void compose(ArrayList<Component> components){
    String result = "";
    for(Component component: components){
      result += component + "\n";
    }

    System.out.print(result);
  }
}
