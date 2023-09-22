import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
    }
    @Test

}
