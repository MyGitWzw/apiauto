package testng.test;

import org.testng.annotations.*;

public class NewTestNG {
    @BeforeClass
    public void setUp(){
        // 在BeforeMethod注解前执行，在Test测试方法之前执行，而且只执行一次
        System.out.println("setUp of New TestNG!");
    }

    @BeforeMethod
    public void testBeforeMethod(){
        //在Test测试方法之前执行，而且每次调用Test方法都会

        System.out.println("setUp of New TestNG!");
    }

    @Test
    public void helloWorld(){
        System.out.println("My first TestNG testCase!");
    }

    @AfterMethod
    public void testAfetrMethod(){


        System.out.println("setUp of New TestNG!");
    }


    @AfterClass
    public void tearDown(){
        System.out.println("tearDown!");
    }
}
