package lesson22;

/**
 * @Author: Wzw
 * @Date: 2021/7/5 20:56
 */
public class TestStatic {
    static {//为了完成数据初始化
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("TestStatic.main()");
        TestStatic testStatic = new TestStatic();
        testStatic.sayHi();
    }
    public void sayHi(){ System.out.println("TestStatic.sayHi()"); }
    public TestStatic(){ System.out.println("TestStatic.TestStatic()"); }
}
