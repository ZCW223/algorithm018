import java.util.Arrays;

/*给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组*/
public class _4mergeSortedArray {
    // 1.暴力+使用Arrays.sort()
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i=nums1.length-nums2.length;i<nums1.length;i++){
            nums1[i]=nums2[j++];
        }
        Arrays.sort(nums1);
    }
}
