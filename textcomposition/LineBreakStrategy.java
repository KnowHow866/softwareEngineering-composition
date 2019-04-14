package textcomposition;

import java.util.ArrayList;

/**
 * Linebreaking strategy.
 * @author group2
 * @since 0.0.1
 */
public interface LineBreakStrategy{
  /**
   * Compose components.
   * @param components components.
   */
  public void compose(ArrayList<Component> components);
}
