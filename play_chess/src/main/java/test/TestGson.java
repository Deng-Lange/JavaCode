package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Student {
    public int id = 20;
    public String name = "xiaoming";
}

public class TestGson {
    public static void main(String[] args) {
        Student student = new Student();
        // JSON 相关的库主要就做两件事
        // 此处之所以不直接new Gson 这个类, 是因为 Gson 这里支持很多的选项.
        // new Gson 就需要手动的设置不少的参数~ GsonBuilder 相当于把这些选项
        // 都设置了一些默认的值. 就可以拿过来直接使用.
        // 这种代码的写法称为 "工厂模式" (一种设计模式)
        Gson gson = new GsonBuilder().create();
        // 1. 把一个对象转换成 JSON 格式的字符串
        String studentString = gson.toJson(student);
        System.out.println(studentString);
        // 2. 把一个 JSON 格式的字符串解析成一个对象
        Student student2 = gson.fromJson(studentString, Student.class);
    }
}
