package Test0126_BookSystem.operation;

import Test0126_BookSystem.BookList;
// 把 BookList 中的所有信息都打印出来
public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        // 显示书籍列表
        System.out.println("显示书籍列表");
        for (int i = 0; i < bookList.getSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
