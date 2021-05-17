package everyday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day19_2 {
    //查找两个字符串 a，b 中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
    /*
    本题需要用动态规划求解，
    maxSubLen[i][j]记录短字符串 str1 前 i 个字符
    和长字符串 str2 前 j 个字符的最长子串的长度，
    当 arr1[i-1]=arr2[j-1] 时，maxSubLen[i][j]=maxSubLen[i-1][j-1]+1，
    start记录最长子串在短字符串 str1 中出现的起始位置，
    maxLen记录当前最长子串的长度，
    当 maxSubLen[i][j]>maxLen 时，maxLen=maxSubLen[i][j]，则 start=i-maxLen；
    当 arr1[i-1]!=arr2[j-1] 时不需要任何操作，
    最后获取 substring(start,start+maxLen) 即为所求。
     */
    //假设 str1 长度短
    public static String getMaxSubstr(String str1,String str2){
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();
        int len1=arr1.length;
        int len2=arr2.length;
        //最长子串的起始位置
        int start=0;
        //最长子串长度
        int maxLen=0;
        //多增加一行一列，作为辅助状态
        //状态：以 a 的第 i 个字符结尾和以 b 的第 j 个字符结尾的最长公共子串的长度
        int[][] maxSubLen=new int[len1+1][len2+1];
        for(int i=1;i<=len1;++i){
            for(int j=1;j<=len2;++j){
                //如果第 i 个字符和第 j 个字符相等，则进行累加
                if(arr1[i-1]==arr2[j-1]){
                   maxSubLen[i][j]=maxSubLen[i-1][j-1]+1;
                   //更新
                    if(maxLen<maxSubLen[i][j]){
                        maxLen=maxSubLen[i][j];
                        start=i-maxLen;
                    }
                }
            }
        }
        return str1.substring(start,start+maxLen);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str1;
        String str2;
        while((str1=reader.readLine())!=null){
            str2=reader.readLine();
            if(str1.length()<str2.length()){
                System.out.println(getMaxSubstr(str1,str2));
            }else{
                System.out.println(getMaxSubstr(str2,str1));
            }
        }
    }
}
