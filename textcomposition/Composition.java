package textcomposition;

import java.util.ArrayList;

/**
 * Compose components.
 * @author group2
 * @since 0.0.1
 */
public class Composition {
  /** List of components */
  private ArrayList<Component> components = new ArrayList<Component>();
  /** linebreaking stragety */
  private LineBreakStrategy lineBreakStrategy;


  /**
   * Arranges component objects into lines using a linebreaking strategy.
   */
  public void compose(){
    this.lineBreakStrategy.compose(this.components);
  }

  /**
   * Set linebreaking strategy.
   * @param LineBreakStrategy linebreaking strategy. 
   */
  public void setLineBreakStrategy(LineBreakStrategy lineBreakStrategy){
    this.lineBreakStrategy = lineBreakStrategy;
  }

  /**
   * Change size of component.
   * @param componentId component ID.
   * @param size size.
   */
  public void changeComponentSize(String componentId, int size){
    for(Component component: this.components){
      if(component.getId().equals(componentId)){
        component.setNaturalSize(size);
        break;
      }
    }
  }

  /**
   * Add component.
   * @param component component.
   */
  public void addComponent(Component component){
    this.components.add(component);
  }
}
