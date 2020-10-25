import java.util.HashMap;
import java.util.Map;

public class _5twoSum {
    //使用HashMap
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> hashtable = new HashMap<Integer,Integer>();
            for(int i = 0; i < nums.length ; ++i){
                if(hashtable.containsKey(target - nums[i])){
                    return new int[]{hashtable.get(target-nums[i]),i};
                }
                hashtable.put(nums[i],i);
            }
            return new int[0];
        }
    }
    // 2、暴力
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int[] a = new int[2];
            for(int i = 0 ; i < nums.length ; i++){
                for(int j = i+1 ; j < nums.length ; j++){
                    if(nums[i] + nums[j] == target ){
                        a[0]=i;
                        a[1]=j;
                        break;
                    }
                }
            }
            return a;
        }

    }

}
