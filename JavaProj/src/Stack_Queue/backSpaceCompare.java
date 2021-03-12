package Stack_Queue;

//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
//判断二者是否相等，并返回结果。 # 代表退格字符
//注意：如果对空文本输入退格字符，文本继续为空
//如果它是退格符，那么我们将栈顶弹出；
//如果它是普通字符，那么我们将其压入栈中。

class backSpaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }
}
