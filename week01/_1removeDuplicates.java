/*
* 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
*/
public class _1removeDuplicates {
    public static int solution(int[] nums){
        int i = 0;
        for (int j = 1 ; j < nums.length ; j++ ) {
            if(nums[i] != nums[j] ){
                i++; // i的起始位为0，所以i++在先
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5,5,7,9};
        int l = solution(nums);
        for(int i = 0 ; i < l ; i ++){
            System.out.print(nums[i]+"\t");
        }
    }
}
