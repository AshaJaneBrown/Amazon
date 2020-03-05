package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.print.Book;

public class AmazonProductPage {

    WebDriver driver;

    public By name = By.id("productTitle");
    public By author = By.xpath("//a[@class='a-link-normal contributorNameID']");
    public By price = By.xpath("//span[@class='a-size-medium a-color-price header-price']");
    public By rating = By.xpath("//span[@data-hook='rating-out-of-text']");
    public By isBestSeller = By.xpath("//i[@class='a-icon a-icon-addon p13n-best-seller-badge']");

    Book book;

    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAuthor() {
        return driver.findElement(author).getText();
    }

    public String getName() {
        return driver.findElement(name).getText();
    }

    public String getRating() {
        return driver.findElement(rating).getText();
    }

    public String getPrice() {
        return driver.findElement(price).getText();
    }

    public String defineBestSellers() {
        String result;
        if (driver.findElements(isBestSeller).size() != 0)
            result = "Best seller";
        else
            result = "Not a best seller";
        return result;
    }
}
