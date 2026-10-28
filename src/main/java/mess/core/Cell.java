package mess.core;

public class Cell {
    private Integer value;
    private boolean fixed;

    public Cell() {}

    public Cell(Integer value, boolean fixed) {
        this.value = value;
        this.fixed = fixed;
    }

    public Integer getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setValue(Integer value) {
        if (fixed) {
            throw new IllegalStateException("Cannot modify a fixed cell.");
        }
        this.value = value;
    }
}
