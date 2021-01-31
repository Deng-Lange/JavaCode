package Test0126_BookSystem.operation;

import Test0126_BookSystem.Book;
import Test0126_BookSystem.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        // 实现还书
        System.out.println("归还书籍");
        System.out.println("请输入要还的书籍的名称: ");
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("书籍没有找到, 无法归还!");
            return;
        }
        // 判定当前这本书是否是已经借阅的状态. 如果没借出, 也就不必归还
        Book currentBook = bookList.getBook(i);
        if (!currentBook.isBorrowed()) {
            System.out.println("这本书没有借出, 无法归还!");
            return;
        }
        currentBook.setBorrowed(false);
        System.out.println("归还书籍成功! ");
        return;
    }
}
