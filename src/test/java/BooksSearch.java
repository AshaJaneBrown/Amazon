import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.AmazonProductPage;
import pages.AmazonSearchResultsPage;

import java.util.ArrayList;
import java.util.List;

public class BooksSearch extends BaseTest{

    ArrayList<Book> books = new ArrayList<Book>();
    List<WebElement> bookElements;
    AmazonSearchResultsPage resultsPage;
    AmazonProductPage productPage;


    @Test (dataProvider = "browser")
    public void addJavaBooksToCollection(String browser) {
        openAmazonPage(browser);
        homePage.enterSearchRequest("Java");
        sleep(5);

        resultsPage = new AmazonSearchResultsPage(driver);
        resultsPage.applyBookFilter();
        sleep(5);
        bookElements = resultsPage.identifyBooks();
        sleep(5);

        productPage = new AmazonProductPage(driver);

        for (int i = 0; i < bookElements.size(); i++) {
            resultsPage.openProductPage(bookElements.get(i));
            sleep(5);
            books.add(new Book(productPage.getName(), productPage.getAuthor(), productPage.getPrice(), productPage.getRating(), productPage.defineBestSellers()));
            sleep(5);
            driver.navigate().back();
            sleep(10);
        }

    }
    public void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


