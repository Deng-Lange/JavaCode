package everyday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day21_2 {
    //MP3光标位置
    public static void mouseMove(String numStr,String orderStr){
        //歌曲数量
        int n=Integer.parseInt(numStr);
        //指令数组：U D
        char[] order=orderStr.toCharArray();
        //当前鼠标所在位置
        int mouse=1;
        //显示列表所在的起始位置
        int first=1;
        //指令处理
        if(n<=4){
            //循环处理每一个指令
            for(int i=0;i<order.length;++i){
                if(mouse==1&&order[i]=='U'){
                    //光标在第一首歌曲上时，按 Up 键光标挪到最后一首歌曲
                    mouse=n;
                }else if(mouse==n&&order[i]=='D'){
                    //光标在最后一首歌曲上时，按 Down 键光标挪到第一首歌曲
                    mouse=1;
                }else if(order[i]=='U'){
                    //其他情况下按 Up 键，光标挪到上一首歌曲
                    --mouse;
                }else if(order[i]=='D'){
                    //其他情况下按 Down 键，光标挪到下一首歌曲
                    ++mouse;
                }
            }
            //输出：打印当前的显示列表
            for(int i=1;i<n;++i){
                System.out.println(i+" ");
            }
            System.out.println(n);
            //打印当前歌曲
            System.out.println(mouse);
        }else{
            for(int i=0;i<order.length;++i){
                //屏幕显示的是第一页（即显示第 1–4 首）时，光标在第一首歌曲上，用户按 Up 键后，
                //屏幕要显示最后一页（即显示第 7-10 首歌），同时光标放到最后一首歌上
                if(first==1&&mouse==1&&order[i]=='U'){
                    //最后一页起始位置
                    first=n-3;
                    mouse=n;
                //屏幕显示最后一页时，光标在最后一首歌曲上，用户按 Down 键，
                //屏幕要显示第一页，光标挪到第一首歌上
                }else if(first==n-3&&mouse==n&&order[i]=='D'){
                    first=1;
                    mouse=1;
                //屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按 Up 键后，
                //屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。
                }else if(first!=1&&mouse==first&&order[i]=='U'){
                    --mouse;
                    --first;
                //屏幕显示的不是第一页时，光标在当前屏幕显示的最后一首歌曲时，用户按 Down 键后，
                //屏幕从当前页面第一首歌曲的下一首开始显示，光标也挪到下一首歌曲。
                }else if(first!=n-3&&mouse==first+3&&order[i]=='D'){
                    first++;
                    mouse++;
                //其他情况，只移动光标
                }else if(order[i]=='U'){
                    --mouse;
                }else if(order[i]=='D'){
                    ++mouse;
                }
            }
            //输出：打印当前的显示列表
            for(int i=first;i<first+3;++i){
                System.out.println(i+" ");
            }
            System.out.println(first+3);
            //打印当前歌曲
            System.out.println(mouse);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String numStr;
        while((numStr=reader.readLine())!=null){
            String orderStr=reader.readLine();
            mouseMove(numStr,orderStr);
        }
    }
}
