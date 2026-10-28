package mess.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    void shouldInitializeEveryCell(){
        Board board = new Board();

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                assertNotNull(board.getCell(row,col));
            }
        }
    }

    @Test
    void shouldReturnCellAtSpecifiedPosition(){
        Board board = new Board();

        Cell cell = board.getCell(4,7);

        assertNotNull(cell);
        assertSame(cell,board.getCell(4,7));
    }

    @Test
    void shouldReturnNullWhenCellIsEmpty(){
        Board board = new Board();

        Integer value = board.getCell(0,0).getValue();

        assertNull(value);
    }

    @Test
    void shouldInsertValueIntoCell() {
        Board board = new Board();

        board.setValue(0, 0, 5);

        assertEquals(5, board.getCell(0, 0).getValue());
    }

    @Test
    void shouldRemoveValueFromCell() {
        Board board = new Board();

        board.setValue(0, 0, 5);
        board.removeValue(0, 0);

        assertNull(board.getCell(0, 0).getValue());
    }

    @Test
    void shouldIdentifyEmptyCell() {
        Board board = new Board();

        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void shouldIdentifyNonEmptyCell() {
        Board board = new Board();

        board.setValue(5, 0, 7);

        assertFalse(board.isCellEmpty(5, 0));

    }

    @Test
    void shouldNotConsiderBoardCompleteWhenThereAreEmptyCells(){
        Board board = new Board();

        assertFalse(board.isComplete());
    }


    @Test
    void shouldConsiderBoardCompleteWhenAllCellsAreFilled() {
        Board board = new Board();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.setValue(row, col, 1);
            }
        }

        assertTrue(board.isComplete());
    }

    @Test
    void shouldRejectInvalidPosition() {
        Board board = new Board();

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> board.getCell(9, 0)
        );
    }

    @Test
    void shouldRejectInvalidRow() {
        Board board = new Board();

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> board.getCell(-1, 0)
        );
    }

    @Test
    void shouldRejectInvalidColumn() {
        Board board = new Board();

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> board.getCell(0, 9)
        );
    }

    @Test
    void shouldAccessLastCell() {
        Board board = new Board();

        assertNotNull(board.getCell(8, 8));
    }

}
