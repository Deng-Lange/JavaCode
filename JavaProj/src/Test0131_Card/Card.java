package Test0131_Card;
// 一张扑克牌
public class Card {
    // 花色
    public String suit;
    // 点数 使用 String 更合理. JQKA
    public String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // 为了方便打印牌的内容, 就可以重写 toString 方法
    @Override
    public String toString() {
        return "(" + this.suit + this.rank + ")";
    }
}
