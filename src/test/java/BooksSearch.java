import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

public class BooksSearch {

    WebDriver driver;

    @DataProvider(name = "browser")
    public static Object[] getBrowser() {
        String[][] objects;
        objects = new String[][]{{"chrome"}};
        return objects;
    }

    @Test (dataProvider = "browser")
    public void search(String browser) {
        driver = DriverManager.getDriver(browser);
        driver.get("https://www.amazon.com");
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("Java");
        searchField.submit();
        sleep();

        WebElement booksSection = driver.findElement(By.id("n/3608"));
//      WebElement booksSection = driver.findElement(By.id("n/283155")); - это правильный вариант, но он совсем не кликается :(

        System.out.println(booksSection.getText());
        booksSection.click();
        sleep();

        List<WebElement> bookItems = driver.findElements(By.xpath("//img[@class='s-image']"));
        System.out.println(bookItems.size());

        Book book = createBook(bookItems.get(0));

//        driver.navigate().back(); - пытаюсь вернуться на страницу со списком книг, но всегда возникает StaleElementReferenceException


        System.out.println(book.author.getText() + ", " + book.name.getText() + ", " + book.price.getText() + ", " + book.rating.getText());
    }

    public Book createBook(WebElement element) {
        Book book = new Book();
        book.item = element;
        book.item.click();
        book.author = driver.findElement(By.xpath("//a[@class='a-link-normal contributorNameID']"));
        book.name = driver.findElement(By.id("productTitle"));
        book.price = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price header-price']"));
        book.rating = driver.findElement(By.xpath("//span[@data-hook='rating-out-of-text']"));
        if (driver.findElements( By.xpath("//i[@class='a-icon a-icon-addon p13n-best-seller-badge']") ).size() != 0)
            book.isBestSeller = true;
        else
            book.isBestSeller = false;

        return book;
    }

    public void sleep(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


