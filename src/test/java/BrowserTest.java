import org.junit.jupiter.api.Test;

public class BrowserTest extends BaseTest {
    @Test
    public void test () throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
    }
}
