public class Book {

    public String name;
    public String author;
    public String price;
    public String rating;
    public boolean isBestSeller;

    public Book(String name, String author, String price, String rating, boolean isBestSeller) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.isBestSeller = isBestSeller;

    }

        public String toString() {
        return (name + ", " + author + ", " + price + ", " + rating);
        }
    }


