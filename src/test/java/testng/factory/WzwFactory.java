package testng.factory;

import org.testng.annotations.Factory;

public class WzwFactory {

    @Factory
    public Object[] test(){
        Object[] obj = new Object[2];

        for (int i = 0; i <obj.length ; i++) {
            WzwTestCaseClass wzwTestCaseClass = new WzwTestCaseClass(i + "");
            obj[i] = wzwTestCaseClass;
        }
        return obj;
    }


}
