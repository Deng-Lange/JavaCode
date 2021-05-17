package everyday;

import java.util.Scanner;

public class day16_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pp;
        String[] p1,p2;
        String str,outString;
        String p="34567891JQKA2";//用 1 表示 10
        while(sc.hasNext()){
            str = sc.nextLine();
            //有王炸就王炸最大
            if(str.contains("joker JOKER")){
                outString = "joker JOKER";
            }else{
                //拆分 先拆成左右 再拆成单排
                pp = str.split("-");
                p1 = pp[0].split(" ");//第一手牌
                p2 = pp[1].split(" ");//第二手牌
                //炸弹最大
                if(p1.length == 4 && p2.length != 4){
                    outString = pp[0];
                }else if(p2.length == 4 && p1.length != 4){
                    outString = pp[1];
                }else if(p2.length == p1.length){
                    //牌数相同的情况下比较第一张牌的大小
                    if(p.indexOf(p1[0].substring(0,1))>p.indexOf(p2[0].substring(0,1))){
                        outString = pp[0];
                    }else{
                        outString = pp[1];
                    }
                }else{
                    outString = "ERROR";
                }
            }
            System.out.println(outString);
        }
    }
}
