
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;

public class SelenuimDemo {
    public static void main(String[] args) {


        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "E:/Program Files/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //get()方法，访问指定的url
        String url = "https://www.baidu.com";
        driver.get(url);

        WebDriverWait webDriverWait1 = new WebDriverWait(driver,10L,1L);


        //输入待搜索的内容，比如：柠檬学院，
        driver.findElement(By.id("kw")).sendKeys("柠檬学院");

        //点击'百度一下' 按钮,id = su is the web element of click button
        driver.findElement(By.id("su")).click();

        //
//        WebDriverWait webDriverWait = new WebDriverWait(driver,5);

        //
        String s = "";
//        driver.findElement(By.xpath("//*[@id=1]/h3/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a")).click();

        // 获取 网页的 title
//        System.out.println("The testing page title is: " + driver.getTitle());
        driver.quit();
    }
}