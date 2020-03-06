import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.AmazonHomePage;

public class BaseTest {

    WebDriver driver;
    AmazonHomePage homePage;
    public static String address = "https://www.amazon.com/";
    String browser;

    public void openAmazonPage(String browser) {
        driver = DriverManager.getDriver(browser);
        homePage = new AmazonHomePage(driver);
        driver.get(address);
    }

    @BeforeClass
    public void start(){
    browser = System.getProperty("browserString");
        openAmazonPage(browser);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}


