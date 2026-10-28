package mess.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    @Test
    void shouldStartEmpty(){
        Cell cell = new Cell();

        assertTrue(cell.isEmpty());
    }

    @Test
    void shouldStoreValue(){
        Cell cell = new Cell(5);

        assertEquals(5, cell.getValue());
    }

    @Test
    void shouldKnowIfCellIsFixed(){
        Cell cell = new Cell(5, true);

        assertTrue(cell.isFixed());
    }

}
