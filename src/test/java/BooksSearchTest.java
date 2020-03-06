import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonProductPage;
import pages.AmazonSearchResultsPage;

import java.sql.SQLOutput;
import java.util.ArrayList;


public class BooksSearchTest extends BaseTest {

   ArrayList<Book> books = new ArrayList<Book>();
   AmazonSearchResultsPage resultsPage;
   AmazonProductPage productPage;

    @Test
    public void findBooksAndAddToCollection() {

        homePage.enterSearchRequest("Java");
        sleep(5);

        resultsPage = new AmazonSearchResultsPage(driver);
        resultsPage.applyBookFilter();
        sleep(5);
        resultsPage.identifyBooks();
        sleep(5);

        int numberOfBooks = resultsPage.foundBooks.size();

        for (int i = 0; i < numberOfBooks; i++) {
            addBook(i);
        }
    }

        public void addBook(int i) {
            if (driver.findElements(By.xpath(resultsPage.getNameXpath(i))).size() > 0 &&
                    driver.findElements(By.xpath(resultsPage.getAuthorXpath(i))).size() > 0 &&
                    driver.findElements(By.xpath(resultsPage.getPriceXpath(i))).size() > 0 &&
                    driver.findElements(By.xpath(resultsPage.getRatingXpath(i))).size() > 0) {
                String bookAuthor = resultsPage.getAuthor(i).getText();
                String bookTitle = resultsPage.getName(i).getText();
                String bookPrice = resultsPage.getPrice(i).getText();
                String bookRating = resultsPage.getRating(i).getText();
                boolean bestSeller = resultsPage.defineBestSellers(i);

                books.add(new Book(bookTitle, bookAuthor, bookPrice, bookRating, bestSeller));
                sleep(5);
            }
        }

    @Test (dependsOnMethods = "findBooksAndAddToCollection")
    public void searchBook(){
        Book book = null;
        boolean found = false;
        int i = 0;
        productPage = new AmazonProductPage(driver);
        driver.get("https://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_3");
        if (driver.findElements(productPage.name).size() > 0 &&
                driver.findElements(productPage.author).size() > 0 &&
                driver.findElements(productPage.rating).size() > 0 &&
                driver.findElements(productPage.price).size() > 0)
        book = new Book(productPage.getName().getText(), productPage.getAuthor().getText(), productPage.getPrice().getText(), productPage.getRating().getText(), productPage.defineBestSellers());

        if (book != null) {
            for (Book b : books) {
                if (b.equals(book)) {
                    found = true;
                    break;
                }
            }
        }


        System.out.println("$$$$$$$$$$$$$");
        for (Book b : books)
            System.out.println(b.toString());
        System.out.println("$$$$$$$$$$$$$");
        System.out.println(book.toString());

  //      Assert.assertTrue(found);

    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


