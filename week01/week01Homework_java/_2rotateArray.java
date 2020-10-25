/*
*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。*/
public class _2rotateArray {
    public static void rotateByForce(int[] nums, int k) {
        /** 暴力！
         1、取出末尾k个
         2、双指针由后向前移动元素
         ? 如果只有k个或者小于k个？？
         **/
        //先处理边界条件
        if (nums.length == 1) return;
        if (nums.length == k) return;
        if (nums.length < k) k = k - nums.length;

        int[] temp = new int[k];
        int t = 0;
        for (int i = nums.length - k; i <= nums.length - 1; i++) {
            temp[t] = nums[i];
            t++;
        }
        t = nums.length - 1;
        for (int i = nums.length - 1 - k; i > -1; i--) {
            nums[t] = nums[i];
            t--;
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] a = {-1};
        int[] b = {1, 2, 3};
        int[] c = {2, 5, 8, 9};
        int[] d = {8, 9};
        rotateByForce(a, k);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println("\n");
        rotateByForce(b, k);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "\t");
        }
        System.out.println("\n");
        rotateByForce(c, k);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + "\t");
        }
        System.out.println("\n");
        rotateByForce(d, k);
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + "\t");
        }
    }
}
