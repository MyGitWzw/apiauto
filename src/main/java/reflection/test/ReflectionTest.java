package reflection.test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Wzw
 * @Date: 2021/5/9 14:35
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


public class ReflectionTest {

    @Test
    public void test1(){

        //反射之前，对于Person类的操作
        Person p1 = new Person("Tom",12);
        p1.age = 10;

        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其私有结构
        // 比如name，showNation()以及私有狗在其
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //1. 通过反射，创建Person 类对象
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());

        //2. 通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射可以调用私有属性和方法以及构造器
        System.out.println("**********开始调用私有结构************");

        //调用私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);

        Person p1 = (Person)cons1.newInstance("Jerry");
        System.out.println("p1" + p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Han,Meimei");

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国");
        System.out.println(p1);

    }

    @Test
    public void test3() throws ClassNotFoundException {
        //方式1，调用运行时类的.class属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //方式2, 调用运行时类的对象，调用getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);



        //方式3, 调用class 的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("reflection.test.Person");
        System.out.println(clazz3);

        //
        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true

        //方式4,使用类加载器 classLoader 显式的加载类
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("reflection.test.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4); //true

    }



}
