package Test0126_BookSystem.operation;

import Test0126_BookSystem.BookList;

public class ExitOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        // 退出程序
        System.out.println("退出程序");
        // 通过这里的 exit 方法就可以直接结束当前程序(结束了当前 jvm 对应的 java 进程)
        System.exit(0);
    }
}
