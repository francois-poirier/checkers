package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class CoordinateTest {

    @Test
    public void givenCoordinateWhenAskForRowThenReturnValue() {
        Coordinate instance = new Coordinate(0, 0);
        assertEquals(0, instance.getRow());
    }

    @Test
    public void givenCoordinateWhenAskForColumnThenReturnValue() {
        Coordinate instance = new Coordinate(0, 0);
        assertEquals(0, instance.getColumn());
    }

    @Test
    public void givenCoordinateWhenCompareTheSameCoordinateThenOK() {
        assertTrue(new Coordinate(0, 1).equals(new Coordinate(0, 1)));
    }
    

    @Test
    public void givenCoordinateWhenCompareDifferentCoordinateThenKO() {
        assertFalse(new Coordinate(0, 1).equals(new Coordinate(2, 3)));
    }


    @Test
    public void givenCoordinateWhenCompareHashThenOK() {
        assertEquals(new Coordinate(1, 2).hashCode(), new Coordinate(1, 2).hashCode());
    }
}