package testng.test;

import org.testng.annotations.*;

public class TestNGHelloWorld {
    @BeforeClass
    public void setUp(){

        System.out.println("setUp!");
    }

    @Test
    public void helloWorld(){
        System.out.println("My first TestNG testCase!");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("tearDown!");
    }
}