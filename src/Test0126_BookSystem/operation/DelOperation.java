package Test0126_BookSystem.operation;

import Test0126_BookSystem.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        // 实现删除一本指定书籍的操作
        System.out.println("删除书籍");
        System.out.println("请输入要删除的书籍的名字: ");
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            if (name.equals(bookList.getBook(i).getName())) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            // 没找到匹配名字的书, 删除失败
            System.out.println("您输入的书籍 [" + name + "] 在系统中没有找到! 删除失败!");
            return;
        }
        // 如果找到了匹配的名字, 就把 i 位置的元素给删除掉即可
        // 如果当前要删除的元素正好是数组的最后一个元素, 直接 size-- 即可
        if (i == bookList.getSize() - 1) {
            bookList.setSize(bookList.getSize() - 1);
            System.out.println("删除成功");
            return;
        }
        // 如果要是需要删除中间元素, 先把最后一个元素给赋值到要删除的元素位置
        // i 是要删除的元素的下标（位置）
        bookList.setBook(i, bookList.getBook(bookList.getSize() - 1));
        // 再删除最后一个元素
        bookList.setSize(bookList.getSize() - 1);
        System.out.println("删除成功");
    }
}
