package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonSearchResultsPage {

    WebDriver driver;
    By filter = By.id("n/3608");

    By product = By.xpath("//div[@class='s-include-content-margin s-border-bottom']");

    String bookSection = "//div[@data-cel-widget='search_result_";

    String name = "//div[@class='s-include-content-margin s-border-bottom']//span[@class='a-size-medium a-color-base a-text-normal']";
    String author = "//div[@class='s-include-content-margin s-border-bottom']//a[@class='a-size-base a-link-normal']";
    String price = "//div[@class='s-include-content-margin s-border-bottom']//span[@class='a-offscreen']";
    String rating = "//div[@class='s-include-content-margin s-border-bottom']//span[@class='a-icon-alt']";
    String isBestSeller = "//div[@class='s-include-content-margin s-border-bottom']//span[@class='a-badge-text']";

    public List<WebElement> foundBooks;

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyBookFilter() {
        driver.findElement(filter).click();
    }

    public void identifyBooks() {
        foundBooks = driver.findElements(product);
    }

    public void openProductPage(WebElement element) {
        element.click();
    }

    public WebElement getAuthor(int i) {
        return driver.findElement(By.xpath(getAuthorXpath(i)));
    }

    public String getAuthorXpath(int i) {
        String s = (bookSection + i + "']" + author);
        return s;
    }

    public WebElement getName(int i) {
        return driver.findElement(By.xpath((getNameXpath(i))));
    }

    public String getNameXpath(int i) {
        String s = (bookSection + i + "']" + name);
        return s;
    }

    public WebElement getRating(int i) {
        return driver.findElement(By.xpath(getRatingXpath(i)));
    }

    public String getRatingXpath(int i) {
        String s = (bookSection + i + "']" + rating);
        return s;
    }

    public WebElement getPrice(int i) {
        return driver.findElement(By.xpath(getPriceXpath(i)));
    }

    public String getPriceXpath(int i) {
        String s = (bookSection + i + "']" + price);
        return s;
    }

    public boolean defineBestSellers(int i) {
        return (driver.findElements(By.xpath((bookSection + i + "']" + isBestSeller))).size() != 0);

    }
}