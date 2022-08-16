import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class JsTest extends BaseTest {
    @Test
    public void jsTest() throws InterruptedException {
        driver.get("https://www.12306.cn/index/");
        Thread.sleep(3000);
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
//        执行js
        jsDriver.executeScript("document.getElementById('train_date').value='2022-09-09'");
//        打印js返回的值
        System.out.println(jsDriver.executeScript("return document.getElementById('train_date').value='2022-09-09'"));
        Thread.sleep(3000);
    }
}
