package everyday;

public class day15_2 {
    /*
    在地下室里放着 n 种颜色的手套，手套分左右手，但是每种颜色的左右手手套个数
    不一定相同。A先生现在要出门，所以他要去地下室选手套。但是昏暗的灯光让他无
    法分辨手套的颜色，只能分辨出左右手。所以他会多拿一些手套，然后选出一双颜色
    相同的左右手手套。现在的问题是，他至少要拿多少只手套（左手加右手），才能保
    证一定能选出一双颜色相同的手套。
    给定颜色种数 n（1≤n≤13），同时给定两个长度为 n 的数组 left，right 分别代表
    每种颜色左右手手套的数量。数据保证左右的手套总数均不超过 26，且一定存在至少
    一种合法方案。
    测试样例：
    4，[0，7，1，6]，[1，5，0，6]
    返回：10
    （解释：可以左手手套取 2 只，右手手套取 8 只）
     */
    public static int findMinimum(int n, int[] left, int[] right) {
        int sum=0;
        int leftSum=0;
        int rightSum=0;
        int leftMin=Integer.MAX_VALUE;
        int rightMin=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            //当碰到某只手某种颜色手套数量为 0 的时候，把另一只手对应的手套数量加起来
            //加到 sum，最后加到求出的手套总数中
            if (left[i]*right[i]==0){
                sum+=(left[i]+right[i]);

            }else{
                leftSum+=left[i];
                rightSum+=right[i];
                if (left[i]<leftMin){
                    leftMin=left[i];
                }
                if (right[i]<rightMin){
                    rightMin=right[i];
                }
            }
        }
        leftSum = leftSum-leftMin+1;
        rightSum= rightSum-rightMin+1;
        if (leftSum<rightSum){
            //最后 +1 代表另一只手的任何一只手套
            return sum+leftSum+1;
        }
        return sum+rightSum+1;
    }

    public static void main(String[] args) {
        int n=4;
        int[] left={0,7,1,6};
        int[] right={1,5,0,6};
        System.out.println(findMinimum(n,left,right));
    }
}
