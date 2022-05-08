package lesson22;

import java.util.*;

/**
 * @Author: Wzw
 * @Date: 2021/7/4 15:55
 */
public class HomeWork {

    public static void saveListToMap(String classNO,List<Student> list){
        HomeWork homeWork = new HomeWork();

        Map<String, List<Student>> map = new HashMap<String, List<Student>>();
        map.put(classNO,list);

        System.out.println("map的第1种遍历方式");

        Set<String> classNames = map.keySet();
        for (String classname:classNames) {
            List<Student> students = map.get(classname);
            for (Student stu:students) {
                System.out.println(stu);
            }
        }

        System.out.println("map的第2种遍历方式");
        for (Map.Entry<String,List<Student>> entry: map.entrySet()) {
            List<Student> students = entry.getValue();
            for (Student stu2: students) {
                System.out.println(stu2);
            }

        }


    }


    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",25,"男");
        Student s2 = new Student("lisi",26,"男");
        Student s3 = new Student("xiaohua",27,"女");

        ArrayList<Student> arrayList = new ArrayList<Student>();
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);

        //删除s3
        arrayList.remove(s3);// arrayList.remove(2)，index = 2
        arrayList.get(0).setName("wangwu");

        HomeWork homeWork = new HomeWork();
        homeWork.saveListToMap("202001",arrayList);


//        System.out.println("==============第一种遍历方式for()");
//        for (int i = 0; i < arrayList.size(); i++) {
//            Student s = arrayList.get(i);
//            System.out.println("姓名"+s.getName()+",年龄"+s.getAge()+",性别"+s.getGender());
//        }
//
//        System.out.println("==============第2种遍历方式增强for");
//
//        for (Student ss:arrayList
//             ) {
//            System.out.println(ss.toString());
//        }
//
//        System.out.println("==============第3种遍历方式iterator");
//        Iterator<Student> iterator = arrayList.iterator();
//        while(iterator.hasNext()){
//            Student s = iterator.next();
//            System.out.println(s.toString());
//        }
    }

}
