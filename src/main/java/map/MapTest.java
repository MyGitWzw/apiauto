package map;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @Author: Wzw
 * @Date: 2021/5/3 10:14
 */
public class MapTest {

    @Test
    public void test1() {
        String str = "File;";

        String[] file = str.split(";");

        System.out.println("the length of file array is " + file.length);
        System.out.println(file.toString());
    }

    @Test
    public void test2() {
        SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");
        formatter3.setTimeZone(TimeZone.getTimeZone("EST"));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        String PMED = formatter3.format(calendar.getTime());
        System.out.println("PMED is: " + PMED);

    }

}
