package mess.sudokli.core;


public class Cell {

  private Integer value;
  private boolean fixed;

  public Cell(){}

  public Cell(Integer value, boolean fixed) {
    this.value = value;
    this.fixed = fixed;
  }

  public Cell(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public boolean isEmpty() {
    return value == null;
  }

  public boolean isFixed(){
    return fixed;
  }

}
