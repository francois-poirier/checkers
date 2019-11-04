package models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PieceTest.class, BoardTest.class, GameTest.class, CoordinateTest.class })

public class AllTest {

	public AllTest() {
	}

}