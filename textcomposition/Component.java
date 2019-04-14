package textcomposition;

/**
 * Component.
 * @author group2
 * @since 0.0.1
 */
public class Component {
  /** ID */
  private String id;
  /** Natural size */
  private int naturalSize;
  /** Stretchability */
  private int stretchability;
  /** Shrinkability */
  private int shrinkability;
  /** Content*/
  private String content;


  /**
   * Constructor.
   * @param id ID.
   * @param naturalSize natural size.
   * @param stretchability stretchability.
   * @param shrinkability shrinkability.
   * @param content contentl
   */
  public Component(String id, int naturalSize, int stretchability, int shrinkability, String content){
    this.id = id;
    this.naturalSize = naturalSize;
    this.stretchability = stretchability;
    this.shrinkability = shrinkability;
    this.content = content;
  }

  /**
   * Format for linebreaking strategy.
   */
  @Override
  public String toString(){
    return String.format("[%s]%s", this.naturalSize, this.content);
  }

  public String getId(){
    return this.id;
  }
  public void setNaturalSize(int naturalSize){
    if(naturalSize < this.shrinkability || this.stretchability < naturalSize){
      System.out.println(String.format("component %s failed to change size", this.id));
    }else{
      System.out.println(String.format("component %s size changed to %d", this.id, naturalSize));
      this.naturalSize = naturalSize;
    }
  }
  public String getContent(){
    return this.content;
  }
}
