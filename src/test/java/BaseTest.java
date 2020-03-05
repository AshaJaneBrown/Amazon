import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import pages.AmazonHomePage;

public class BaseTest {

    WebDriver driver;
    AmazonHomePage homePage;
    public static String address = "https://www.amazon.com/";

    public void openAmazonPage(String browser) {
        driver = DriverManager.getDriver(browser);
        homePage = new AmazonHomePage(driver);
        driver.get(address);
    }

    public void closeBrowser() {

        driver.quit();
    }

    @DataProvider(name = "browser")
    public static Object[] getBrowser() {
        String[][] objects;
        objects = new String[][]{{"chrome"}, {"firefox"}};
        return objects;
    }
}
