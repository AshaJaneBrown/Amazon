import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonProductPage;
import pages.AmazonSearchResultsPage;
import java.util.ArrayList;


public class BooksSearch extends BaseTest {

    ArrayList<Book> books = new ArrayList<Book>();
    AmazonSearchResultsPage resultsPage;
    AmazonProductPage productPage;

    @Test
    public void check() {
        openAmazonPage("chrome");
        homePage.enterSearchRequest("Java");
        sleep(5);

        resultsPage = new AmazonSearchResultsPage(driver);
        resultsPage.applyBookFilter();
        sleep(5);
        resultsPage.identifyBooks();
        sleep(5);

        productPage = new AmazonProductPage(driver);
        int numberOfBooks = resultsPage.foundBooks.size();

        for (int i = 0; i < numberOfBooks; i++) {
            resultsPage.identifyBooks();
            resultsPage.openProductPage(resultsPage.foundBooks.get(i));
            sleep(5);
            addBook(productPage);
            sleep(5);
            driver.navigate().back();
            sleep(10);
        }
        System.out.println(books.size());
        searchBook(books);
    }

    public void searchBook(ArrayList<Book> books){
        ArrayList<String> bookTitles = new ArrayList<String>();
        System.out.println(books.size());

        for (int i = 0; i < books.size(); i++)
        {
            System.out.println(books.get(i).toString());
            bookTitles.add(books.get(i).name);
        }

        for (int i = 0; i < bookTitles.size(); i++)
        {
            System.out.println(bookTitles.get(i));
        }

        Assert.assertTrue(bookTitles.contains("Head First Java, 2nd Edition"));
        }

    public void addBook(AmazonProductPage page) {
        if (driver.findElements(page.name).size() > 0 &&
            driver.findElements(page.author).size() > 0 &&
            driver.findElements(page.rating).size() > 0 &&
            driver.findElements(page.price).size() > 0)
        books.add(new Book(page.getName().getText(), page.getAuthor().getText(), page.getPrice().getText(), page.getRating().getText(), page.defineBestSellers()));
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


