public class _7plusOne {

    // 1、自己写的
    class Solution {
        public int[] plusOne(int[] digits) {
            int temp=0;
            int add=1;
            for(int i=digits.length-1;i>=0;i--){
                if(add==0)continue;
                temp = digits[i]+1;
                if(temp==10)
                {
                    digits[i]=0;
                    add = 1;
                }else{
                    add = 0;
                    digits[i]=temp;
                }
            }
            if(add == 1){
                int[] ex = new int[digits.length+1];
                for(int i=digits.length;i>0;i--)
                {
                    ex[i]=digits[i-1];
                }
                ex[0]=1;
                digits=ex;
            }
            return digits;
        }
    }
    // 2、一个好题解
    class Solution2 {
        public int[] plusOne(int[] digits) {
            for(int i = digits.length -1 ; i >=0 ; i--){
                digits[i]++;
                digits[i] = digits[i]%10;
                if(digits[i] != 0)return digits;
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }
}
