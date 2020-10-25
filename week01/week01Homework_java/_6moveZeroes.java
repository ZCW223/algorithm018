public class _6moveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            // 快慢指针法
            int i = 0 ;
            for(int j = 0;j<nums.length; j++){
                if(nums[j]!=0){
                    nums[i++]=nums[j];
                }
            }
            for( ;i < nums.length ; ){
                nums[i++] = 0;
            }
        }
    }
    class Solution2 {
        // 一次遍历双指针交换
        public void moveZeroes(int[] nums) {
            int i = 0;
            int t;
            for(int j = 0 ; j < nums.length ; j++){
                if(nums[j] != 0 ){
                    t = nums[j];
                    nums[j]=nums[i];
                    nums[i++]=t;
                    //非零都被有序的调到了前面，所以后面一定是剩下0
                }
            }
        }
    }

}
