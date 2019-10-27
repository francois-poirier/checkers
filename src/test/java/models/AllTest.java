package models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    PieceTest.class,
    SquareTest.class,
    BoardTest.class,
    CoordinateTest.class,
    SquareTest.class,
    StateTest.class,
    TurnTest.class
})

public class AllTest{

    public AllTest(){}

}