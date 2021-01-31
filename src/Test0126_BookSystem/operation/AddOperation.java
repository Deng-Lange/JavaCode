package Test0126_BookSystem.operation;

import Test0126_BookSystem.Book;
import Test0126_BookSystem.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner=new Scanner(System.in);
        // 里面实现具体的新增操作
        System.out.println("新增书籍");
        System.out.println("请输入新书籍的名字：");
        String name=scanner.next();
        System.out.println("请输入新书籍的作者：");
        String author=scanner.next();
        System.out.println("请输入新书籍的价格：");
        double price=scanner.nextDouble();
        System.out.println("请输入新书籍的类别：");
        String type=scanner.next();
        Book newBook=new Book(name,author,price,type);
        // 把这本新的书放到 BookList 的末尾即可.
        int curSize = bookList.getSize();
        bookList.setBook(curSize, newBook);
        bookList.setSize(curSize + 1);
        System.out.println("新增书籍成功!");
    }
}
