import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    public static WebDriver driver;
    @BeforeAll
    public static void initData(){
        String browserName=System.getenv("browser");
        if ("chrome".equals(browserName)){
            driver=new ChromeDriver();
        }
        else if ("firefox".equals(browserName)){
            driver=new FirefoxDriver();
        }
    }
    @AfterAll
    public static void closeDriver(){
        driver.quit();
    }
}
