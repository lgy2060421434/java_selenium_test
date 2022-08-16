import org.junit.jupiter.api.BeforeAll;

public class Tests {
   @org.junit.Test
    public  void ptet(){
       String browserName=System.getenv("browser");
       System.out.println("browser:++"+browserName);
       System.out.println("test1");
    }
    @BeforeAll
    public static void tes(){
        System.out.println("tese2");
    }
}
