学习笔记
public class FindUnOrder {
    public static void main(String[] args) {
        int[] datas = {4, 5, 6, 7, 0, 1, 2};
        int targetId = opt(datas);
        System.out.println(targetId + "\t" + datas[targetId]);
    }
/**
 *  问题：寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
 *  题目分析：这样一个前半段有序后半段也是有序的数组
 *  本质就是旋转数组寻找最小值问题
 *  使用二分查找 代码如下
 *  反复比较中间值和右端的大小
 *  如果中间值大就把寻找区间往右移动
 *  反之往左移动直到找到最小中间元素的下标并输出
 */

    private static int opt(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if (numbers[mid] > numbers[right])
                left = mid + 1;
            else if (numbers[mid] < numbers[right])
                right = mid ;
            else right -=1;
        }
        return left;
    }
}
