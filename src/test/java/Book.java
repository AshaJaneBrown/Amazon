import org.openqa.selenium.WebElement;

public class Book  {

    public String name;
    public String author;
    public String price;
    public String rating;
    public String isBestSeller;

    public Book(String name, String author, String price, String rating, String isBestSeller) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.isBestSeller = isBestSeller;
    }
}

