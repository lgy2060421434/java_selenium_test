import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class UploadTest extends BaseTest{
    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='soutu-btn']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='upload-pic']")).sendKeys("C:/Users/liguangyao/Desktop/IMG20220704144723.jpg");
        Thread.sleep(20000);
    }
}
