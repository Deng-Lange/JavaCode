package everyday;

public class day6_2 {
    //把字符串转换成整数
    public int strToInt(String str) {
        char[] ch=str.toCharArray();
        if(str==null||ch.length==0){
            return 0;
        }
        //处理正负号
        int flag=1;
        if(ch[0]=='-'){
            flag=-1;
            ch[0]='0';
        }else if(ch[0]=='+'){
            flag=1;
            ch[0]='0';
        }
        //处理字符串
        int sum=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]<'0'||ch[i]>'9'){
                sum=0;
                break;
            }
            sum=sum*10+ch[i]-'0';
        }
        return flag*sum;
    }
}
