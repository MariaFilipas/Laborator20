import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("Initialize driver ...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Closing the driver ...");
        driver.quit();
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
