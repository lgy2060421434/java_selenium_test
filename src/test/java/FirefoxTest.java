import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirefoxTest {


    public static void main(String[] args) {

//        System.setProperty("webdriver.firefox.bin","d:/Firefox/firefox.exe");
//        System.setProperty("webdriver.chrome.driver", "C:/Users/liguangyao/AppData/Local/Chromium/Application/chromedriver.exe");
//浏览器的webdriver 和浏览器的安装路径

        WebDriver driver = new ChromeDriver();
//        隐式等待（全局）
//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.baidu.com/");

//打开百度
        WebElement search_text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kw")));
        search_text.sendKeys("大能手");
//        WebElement search_text = driver.findElement(By.id("kw"));

//定位到百度搜索

//        search_text.sendKeys("大能手");//搜索关键字

        search_text.submit();

        driver.quit();//关闭浏览器

    }

}