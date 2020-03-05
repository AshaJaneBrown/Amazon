import org.openqa.selenium.WebElement;

public class Book {

    public WebElement name;
    public WebElement author;
    public WebElement price;
    public WebElement rating;
    public boolean isBestSeller;

    public Book(WebElement name, WebElement author, WebElement price, WebElement rating, boolean isBestSeller) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.isBestSeller = isBestSeller;

    }
        public String toString() {
        return (name.getText() + ", " + author.getText() + ", " + price.getText() + ", " + rating.getText() + ", ");

        }
    }


