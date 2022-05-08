package abstracttest;

/**
 * @Author: Wzw
 * @Date: 2021/7/4 15:16
 */
public class TestAbs {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        Teacher teacher = new Teacher();
        doctor.showDaily();
        System.out.println("==============================");
        teacher.showDaily();
    }
}
