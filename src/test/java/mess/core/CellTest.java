package mess.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    @Test
    void shouldStartEmpty(){
        Cell cell = new Cell();

        assertTrue(cell.isEmpty());
    }

    @Test
    void shouldStoreValue(){
        Cell cell = new Cell(5,false);

        assertEquals(5, cell.getValue());
    }

    @Test
    void shouldKnowIfCellIsFixed(){
        Cell cell = new Cell(5, true);

        assertTrue(cell.isFixed());
    }
    @Test
    void shouldNotModifyFixedCell() {
        Board board = new Board();

        Cell cell = new Cell(5,true);

        assertThrows(
                IllegalStateException.class,
                () -> cell.setValue(8)
        );

        assertEquals(5, cell.getValue());
    }

    @Test
    void shouldNotRemoveValueFromFixedCell() {
        Cell cell = new Cell(5, true);

        assertThrows(
                IllegalStateException.class,
                () -> cell.setValue(null)
        );

        assertEquals(5, cell.getValue());
    }
}
