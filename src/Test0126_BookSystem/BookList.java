package Test0126_BookSystem;

// 通过这个类把多个 Book 对象给组织起来
public class BookList {
    // 100 相当于这个 BookList 的 capacity，即最大容量
    private Book[] books = new Book[100];
    //Book 的个数
    private int size = 0;

    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", 100, "古典小说");
        books[1] = new Book("西游记", "吴承恩", 100, "古典小说");
        books[2] = new Book("金瓶梅", "兰陵笑笑生", 110, "古典小说");
        size = 3;
    }

    // 后面需要针对其中的某一本书进行操作.、
    // 使用 alt + insert 能生成 getter 和 setter 方法
    public Book getBook(int index) {
        return books[index];
    }

    public void setBook(int index, Book book) {
        books[index] = book;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
