package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonSearchResultsPage {
    WebDriver driver;
    By filter = By.id("n/3608");
    By product = By.xpath("//img[@class='s-image']");


    public AmazonSearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public void applyBookFilter(){
        driver.findElement(filter).click();
    }

    public List<WebElement> identifyBooks(){
        return driver.findElements(product);
    }
    public void openProductPage(WebElement element) {
        element.click();
    }
}
