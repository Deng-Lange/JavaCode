package Test0126_BookSystem.operation;

import Test0126_BookSystem.Book;
import Test0126_BookSystem.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        // 实现借书操作
        System.out.println("借阅书籍");
        System.out.println("请输入要借阅的书籍的名称: ");
        String name = scanner.next();

        // 找到指定书籍的位置
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            // 没找到
            System.out.println("未找到指定的书籍, 无法借阅!");
            return;
        }
        // 如果找到了对应的书籍, 再判断当前这本书是否已经被借阅了
        Book currentBook = bookList.getBook(i);
        if (currentBook.isBorrowed()) {
            // 已经被借阅了, 不能继续借阅
            System.out.println("该书籍已经被借出!");
            return;
        }
        currentBook.setBorrowed(true);
        System.out.println("借书成功!");
    }
}
