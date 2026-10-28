package mess.core;

public class Board {
    private final Cell[][] cells = new Cell[9][9];

    public Cell getCell(int row, int col) {
        validatePosition(row, col);
        return cells[row][col];
    }

    public Board(){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                Cell cell = new Cell();
                cells[row][col] = cell;
            }
        }
    }

    public void setValue(int row, int col, Integer value) {
        Cell cell = getCell(row, col);
        cell.setValue(value);
    }

    public void removeValue(int row, int col) {
        setValue(row, col, null);
    }

    public boolean isCellEmpty(int row, int col) {
        return getCell(row, col).isEmpty();
    }

    public boolean isComplete() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (isCellEmpty(row, col)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void validatePosition(int row, int col) {
        if (row < 0 || row >= 9 || col < 0 || col >= 9) {
            throw new IndexOutOfBoundsException(
                    "Position out of bounds: row=" + row + ", col=" + col
            );
        }
    }
}
