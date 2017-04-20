package _03_21;

public class Buch {

    private final String title;
    private final String author;
    private final double price;
    private final int isbn;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getIsbn() {
        return isbn;
    }

    public Buch() {
        this("Java ist auch eine Insel", "Christian Ullenboom", 49.99, 015615);
    }

    public Buch(String title, String author, double price, int isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }
}