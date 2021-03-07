package Homework;

    public class Test_day1 {
        public static void  mystery(int x){
            System.out.print(x % 10);
            if ((x / 10) != 0){
                mystery(x / 10);
            }
            System.out.print(x % 10);
        }
        //将字符串里的大写字符转成小写字符，a-z的ASCII值是97到122,A-Z的ASCII值是65到90
        //先将字符串转为字符数组,如果当前字符在大写字母的范围内,就将其转为小写字母，可以用字符相减，也可以直接加32
        public static String toLowerCase(String str) {
            char[] arr = str.toCharArray();
            for (int i=0; i<arr.length; i++) {
                if (arr[i] >= 'A' && arr[i] < 'Z') {
                    arr[i] = (char)(arr[i]+32);  //也可以直接加32
                    //arr[i] = (char)(arr[i]+'a'-'A');
                }
            }
            return new String(arr);
        }
        //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
        public static int[] rotate(int[] nums, int k) {
            while(k > 0) {
                int temp = nums[nums.length-1];
                for(int i = nums.length-1;i > 0; i--) {
                    nums[i] = nums[i-1];
                }
                nums[0] = temp;
                k--;
            }
            return nums;
        }

        public static void main(String[] args) {
//            int x=20,y=5;
//            System.out.println(x+y+" "+(x+y)+y);

            mystery(1234);

//            String str="DENG";
//            System.out.println(toLowerCase(str));

//            int arr[] = {1,2,3,4,5};
//            int k = 3;
//            int arry[] = rotate(arr,k);
//            for(int i=0;i<arry.length;i++){
//                System.out.print(arry[i]+" ");
//            }
        }
    }


