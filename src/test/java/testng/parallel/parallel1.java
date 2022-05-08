package testng.parallel;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class parallel1 {

    @BeforeClass
    public void bfClass(){
        long id = Thread.currentThread().getId();
        System.out.println(" parallel1 before case Thread id " + id);
    }


    @Test
    public void test1(){
        long id = Thread.currentThread().getId();
        System.out.println(" parallel1 test Thread id " + id);
    }

    @AfterClass
    public void afClass(){
        long id = Thread.currentThread().getId();
        System.out.println(" parallel1 after case Thread id " + id);
    }
}
