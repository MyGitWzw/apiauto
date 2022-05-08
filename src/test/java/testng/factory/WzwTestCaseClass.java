package testng.factory;

import org.testng.annotations.Test;

public class WzwTestCaseClass {
    private String str;

//    right click + Generate, and then select Construtor
    public WzwTestCaseClass(String str) {
        this.str = str;
    }

    @Test
    public void login(){
        System.out.println("login...");
    }

    @Test(dependsOnMethods = "login")
    public void logoff(){
        System.out.println("logoff...");
    }


}
