package Stack_Queue;

import java.util.Stack;

//括号匹配问题--使用栈来完成
//1、遍历字符串，如果当前是左括号，就入栈；
//2、如果当前是右括号，就拿当前的右括号和栈顶元素比较，看是否匹配；
//   如果匹配，就把栈顶元素出栈，继续遍历下一个字符；
//   如果不匹配，就说明当前字符串是非法的；
//3、字符串遍历结束后，并且栈也同时为空，就说明该字符串是合法的。

public class Bracket {
    public boolean isValid(String s) {
        // 首先需要创建一个栈
        Stack<Character> stack = new Stack<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果遇到左括号, 就需要入栈
            // '(' 和 "("
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            // 右括号的情况了(题目中要求了字符串只包含括号, 没有其他字符)
            // 取栈顶元素和当前的括号进行匹配
            // 标准库的 Stack, 在针对空栈进行 peek 的时候会直接抛异常.
            if (stack.isEmpty()) {
                return false;
            }
            // 此处直接使用 pop, 把栈顶元素出栈. 一旦匹配的情况, 就直接 continue 进入下次循环就好了.
            Character top = stack.pop();
            if (top == '(' && c == ')') {
                continue;
            }
            if (top == '[' && c == ']') {
                continue;
            }
            if (top == '{' && c == '}') {
                continue;
            }
            // 如果没有触发到上面的三种合法情况, 此时就认为是非法情况, 就直接返回 false
            return false;
        }
        // 循环结束, 说明字符串就遍历完了.
        // 还需要判定一下, 栈是否为空.
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
