import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WindowTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    @BeforeAll
    public static void initDate() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //多窗口切换
    @Test
    public void windowTest() {
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("div#u1 >a")).click();
//        当前窗口的句柄
        String windowHandle = driver.getWindowHandle();
        driver.findElement(By.id("TANGRAM__PSP_11__regLink")).click();
//        获取所有窗口的句柄并判断
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(windowHandle)) {
                driver.switchTo().window(win);
                driver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("ashin");
                driver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("18890908899");
                driver.switchTo().window(windowHandle);
                driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("ashin");
                driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("18890908899");
            }
        }

    }
//Frame窗口测试
    @Test
    public void ifrme() {
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
//        进入frame,通过frame进入
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.id("draggable")).getText());
//        父级，也就是退出frame
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("submitBTN")).getText());
        driver.quit();
    }


}
