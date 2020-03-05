package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonSearchResultsPage {
    WebDriver driver;
    By filter = By.id("n/3608");
    By product = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    public List<WebElement> foundBooks;


    public AmazonSearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public void applyBookFilter(){
        driver.findElement(filter).click();
    }

    public void identifyBooks(){
        foundBooks =  driver.findElements(product);
    }
    public void openProductPage(WebElement element) {
        element.click();
    }
}
