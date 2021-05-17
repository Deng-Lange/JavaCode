package everyday;

import java.util.Scanner;

public class day21_1 {
    /*
    洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗 2n 张牌，
    从上到下依次是第 1 张，第 2 张，第 3 张一直到第 2n 张。
    首先，我们把这 2n 张牌分成两堆，左手拿着第 1 张到第 n 张（上半堆），
    右手拿着第 n+1 张到第 2n 张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，
    再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，
    直到最后放下左手的第一张牌。接着把牌合并起来就可以了。
    例如有 6 张牌，最开始牌的序列是 1,2,3,4,5,6。
    首先分成两组，左手拿着 1,2,3；右手拿着 4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1。
    把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，
    就变成了序列 1,4,2,5,3,6。
    现在给出一个原始牌组，请输出这副牌洗牌 k 次之后从上往下的序列。
    左手位置变化：i--->2*i；
    右手位置变化：i+n--->2*i+1。（索引从 0 开始）
     */
    public static void playCard(int[] cards,int n,int k){
        //一共有 2*n 张牌，k 为洗牌次数
        //i-->2*1
        //i+n--->2*i+1
        for(int i=0;i<k;++i){
            //一次洗牌的过程
            int[] newCards=new int[cards.length];
            //遍历编号为 0 ~ n-1
            for(int j=0;j<n;++j){
                newCards[2*j]=cards[j];
                newCards[2*j+1]=cards[j+n];
            }
            cards=newCards;
        }
        //从上往下打印
        printCards(cards);
    }
    private static void printCards(int[] cards) {
        for(int i=0;i<cards.length-1;++i){
            System.out.println(cards[i]+" ");
        }
        System.out.println(cards[cards.length-1]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int groups=sc.nextInt();
        for(int i=0;i<groups;++i){
            //读入每组数据
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] cards=new int[2*n];
            for(int j=0;j<2*n;++j){
                cards[j]=sc.nextInt();
            }
            //洗牌
            playCard(cards,n,k);
        }
    }
}
