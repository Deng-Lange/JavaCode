package everyday;

import java.util.Scanner;

public class day10_2 {
    //机器人走方格
    //f(m,n)=f(m-1,n)+f(m,n-1)
    public int countWays(int x, int y) {
        if ( x==1 || y==1 )
            return 1;
        return countWays(x-1,y)+countWays(x,y-1);
    }
}
