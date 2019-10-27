package controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    CancelControllerTest.class,
    MoveControllerTest.class,
    ResumeControllerTest.class,
    StartControllerTest.class
})

public class AllTest{

    public AllTest(){}

}