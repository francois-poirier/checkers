package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {

    @Test
    public void testGivenTwoCoordinatesWhenBetweenDiagonalThenOk() {
        assertEquals(new Coordinate(1, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 0)));
        assertEquals(new Coordinate(3, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 0)));
        assertEquals(new Coordinate(3, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 4)));
        assertEquals(new Coordinate(1, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 4)));
    }

    @Test
    public void testGivenTwoCoordinatesWhenBetweenDiagonalDistanceThenOk(){
        assertEquals(3,new Coordinate(3, 4).diagonalDistance(new Coordinate(0, 7)));
    }

    @Test
    public void testGivenTwoCoordinatesWhenIsDiagonalThenOK(){
        assertTrue(new Coordinate(3, 3).isDiagonal(new Coordinate(4, 4)));
    }

    @Test
    public void testGivenTwoCoordinatesWhenIsDiagonalThenKO(){
        assertFalse(new Coordinate(4, 1).isDiagonal(new Coordinate(4, 2)));
    }

    @Test
    public void testGivenACoordinateWhenIsValidThenOK(){
        assertTrue(new Coordinate(2, 1).isValid());
    }

    @Test
    public void testGivenACoordinateWhenIsValidThenKO(){
        assertFalse(new Coordinate(8, 1).isValid());
    }

}