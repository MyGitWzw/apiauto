package reflection.test;

/**
 * @Author: Wzw
 * @Date: 2021/5/9 13:56
 */


/**
 * 关于java.lang.Class类的理解
 * 1.类加载过程
 * 程序经过javac.exe 命令（即编译） 生成 一个或者多个字节码文件（.class结尾）。
 * 接着使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中，此过程成为类加载
 * 加载到内存中的类，称为运行时类，此运行时类，就是Class的一个实例。
 *
 * 2. 如何获取Class实例的方式
 *
 * **/

public class Person {
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    public void show(){
        System.out.println("你好，我是一个人");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }
}
