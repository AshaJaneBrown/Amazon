package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonProductPage {

    WebDriver driver;

    public By name = By.id("productTitle");
    public By author = By.xpath("//a[@class='a-link-normal contributorNameID']");
    public By price = By.xpath("//span[@class='a-size-medium a-color-price header-price']");
    public By rating = By.xpath("//span[@data-hook='rating-out-of-text']");
    public By isBestSeller = By.xpath("//i[@class='a-icon a-icon-addon p13n-best-seller-badge']");


    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAuthor() {
        return driver.findElement(author);
    }

    public WebElement getName() {
        return driver.findElement(name);
    }

    public WebElement getRating() {
        return driver.findElement(rating);
    }

    public WebElement getPrice() {
        return driver.findElement(price);
    }

    public boolean defineBestSellers() {
        return (driver.findElements(isBestSeller).size() != 0);

    }
}
