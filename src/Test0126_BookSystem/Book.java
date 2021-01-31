package Test0126_BookSystem;

// Book 类用来表示一本书的信息
// 这些信息通过 Book 类的属性来表示
public class Book {
    // 原则是, 能用 private 就尽量用 private
    private String name;
    private String author;
    private double price;
    private String type;
    private boolean isBorrowed = false;

    // 使用构造方法针对这些私有成员进行初始化
    public Book(String name, String author, double price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    public String getName() {
        return name;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
