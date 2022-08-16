import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QiYeWeChard extends BaseTest {
//    获取cookie的值放入yaml文件里面
//    @Test
//    public void logginTest() throws IOException, InterruptedException {
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("http://work.weixin.qq.com/wework_admin/frame");
//        Thread.sleep(15000);
//        Set<Cookie> cookies = driver.manage().getCookies();
//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        mapper.writeValue(new File("cookies.yaml"), cookies);
//    }

//    将yaml文件里面的值提取出来然后放到浏览器cookie里面登录
    @Test
    public void logginTest1() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://work.weixin.qq.com/wework_admin/frame");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        反序列化到map集合里面
        TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String, Object>> Cookies = (List<HashMap<String, Object>>) mapper.readValue(new File("cookies.yaml"), typeReference);
        System.out.println(Cookies);
        Cookies.forEach(cookiesMap->{
            driver.manage().addCookie(new Cookie(cookiesMap.get("name").toString(),cookiesMap.get("value").toString()));
            System.out.println(cookiesMap.get("name").toString());
        });
        driver.navigate().refresh();
        Thread.sleep(5000);
    }
}
