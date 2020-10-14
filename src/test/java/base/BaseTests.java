package base;

import com.ratn.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();

        //driver.manage().window().fullscreen();

        /*
         * for phone size
         */
        //driver.manage().window().setSize(new Dimension(375, 812));

        homePage = new HomePage(driver);
    }

    /*public static void main(String[] args) {
        BaseTests tests = new BaseTests();
        tests.setUp();
        tests.tearDown();
    }*/

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
