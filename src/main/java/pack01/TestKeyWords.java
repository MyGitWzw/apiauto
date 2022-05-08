package pack01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestKeyWords {
    WebDriver chromeDriver;

    //打开浏览器
    public void openBroswer(String broswerType,String url){
        if(broswerType.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "E://Program Files//chromedriver_win32//chromedriver.exe");
            this.chromeDriver = new ChromeDriver();
            this.chromeDriver.get(url);
        }else{
            System.out.println("Input browser type error!");
        }
    }

    //定位元素
    public WebElement locator(String locatorType, String byValue){
        WebElement we = null;
        if(locatorType.equals("id")){
            we = chromeDriver.findElement(By.id(byValue));
//            we = chromeDriver.findElement(By.partialLinkText("新闻"));

            return we;
        }else if(locatorType.equals("xpath")){
            we = chromeDriver.findElement(By.xpath(byValue));
            return we;
        }else if(locatorType.equals("cssSelector")){
            chromeDriver.findElement(By.cssSelector(byValue));
        }
        return we;
    }

    // 输入关键字
    public void inputText(String locatorType, String byValue,String input){
        WebElement we = locator(locatorType,byValue);
        we.sendKeys(input);
    }


    public void clickElement(String locatorType, String byValue){
        locator(locatorType,byValue).click();
    }


    public static void main(String[] args) {
        String browserType = "chrome";
        String url = "https://www.baidu.com";
//        TestKeyWords tk1 = new TestKeyWords();
//        tk1.openBroswer(browserType,url);
//        tk1.inputText("id","kw","乔峰");     //定位搜索框，并输入“乔峰”为搜索内容
//        tk1.clickElement("id","su");               //点击 百度一下 按钮

        TestKeyWords tk2 = new TestKeyWords();
        tk2.openBroswer(browserType,"https://www.jd.com");
        tk2.inputText("id","key","乔峰");     //定位搜索框，并输入“乔峰”为搜索内容
        tk2.clickElement("cssSelector","#search > div > div.form > button");               //点击 京东一下
    }
}
