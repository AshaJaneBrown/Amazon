import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver getDriver(String browser) {
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src/main/resources/geckodriver.exe");
            return new FirefoxDriver();
        }
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/main/resources/chromedriver.exe");
            return new ChromeDriver();
        }
        else
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/main/resources/chromedriver.exe");
            return new ChromeDriver();
    }
}

