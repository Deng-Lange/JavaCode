package Test0126_BookSystem;

import Test0126_BookSystem.operation.IOperation;

//如果多个类之间，公共的部分只有方法的话，此时使用接口；
//如果多个类之间，公共的部分不只有方法，还有属性，此时使用继承。

// User 这个类用来作为 Admin 和 NormalUser 的父类
// 存放两种角色的公共信息的
// User 类不应该被实例化. 角色实际就只有管理员和普通用户两种
// 于是就做成一个抽象类, 防止后面不小心对 User 实例化了, 编译就能给出报错
public abstract class User {
    protected String name;
    protected IOperation[] operations;

    // 这个方法用来打印该用户的菜单
    // 不同的用户支持的操作不一样, 菜单内容也不一样.
    // 此处就做成抽象方法, 再由该类的子类来进一步的重写这样的方法
    public abstract int menu();

    public void doOperation(int choice, BookList bookList) {
        // 如果 choice 是 1, 并且当前 user 是 Admin 的话,
        // 此时取下标为 0 的元素, 就得到了一个 FindOperation 的实例
        // 此时 operation 这个引用指向的就是这个 FindOperation 实例
        IOperation operation = this.operations[choice - 1];
        // 再调用 work 方法, 这也是父类引用调用方法, 实际执行的是 引用对应的子类的方法
        operation.work(bookList);
    }
}
