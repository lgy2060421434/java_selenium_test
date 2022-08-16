import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InteractiveTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    @BeforeAll
    public static void initDate() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void clicTest() {
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.cssSelector("#kw"));
        actions.sendKeys(element, "测试");
        actions.click(driver.findElement(By.id("su")));
        actions.doubleClick(driver.findElement(By.id("su")));
//        鼠标移动
//        actions.moveToElement(driver.findElement(By.cssSelector("a[name='tj_settingicon']")));
        actions.perform();
    }

    @Test
    public void moveTest() {
        //        鼠标移动
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.cssSelector("#kw"));
        actions.sendKeys(element, "测试");
        actions.moveToElement(driver.findElement(By.cssSelector("a[name='tj_settingicon']")));
        actions.perform();
    }

    @Test
    public void gdt() throws InterruptedException {
//        一个元素拖拽到另一个元素身上
        driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
        actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("//*[@class='item'][last()]"))).perform();
    }

    @Test void huadon() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        driver.findElement(By.cssSelector("#kw")).sendKeys("霍格沃兹测试");
//        driver.findElement(By.id("su")).click();
//        滑动操作
        driver.manage().window().maximize();
        TouchActions actions=new TouchActions(driver);
        actions.click(driver.findElement(By.id("su")));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@class='n']")).click();
        Thread.sleep(3000);

    }


    @Test
    public void jpcz() throws InterruptedException {
//     测试复制粘贴操作，键盘按压
        driver.get("http://sahitest.com/demo/label.htm");
        driver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("ashin");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        actions.keyDown(driver.findElements(By.xpath("//input[@type='textbox']")).get(1), Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);
    }

    @AfterAll
    public static void lastStep() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
