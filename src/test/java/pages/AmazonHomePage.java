package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
    WebDriver driver;

    By searchField = By.id("twotabsearchtextbox");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchRequest(String searchRequest) {
        driver.findElement(searchField).sendKeys(searchRequest);
        driver.findElement(searchField).submit();
    }

    public boolean atPage(String pageTitle){
        return driver.getTitle().equals(pageTitle);

    }
}
