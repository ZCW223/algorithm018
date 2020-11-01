package Week02;
/**我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。*/
/**示例:

 输入: n = 10
 输出: 12
 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 说明:  

 1 是丑数。
 n 不超过1690。
 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class _8UglyNumber {
}

class Solution {
    private int[] uglyNumber = {2,3,5};
    public int nthUglyNumber(int n) {
        //创建小根堆，每次出堆的都是最小值
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        //记录出堆的个数，出堆的元素完全按照从小到大排序
        int count = 0;
        while (! queue.isEmpty()){
            long cut = queue.poll();

            //如果出堆的个数>=n,当前cut就是第n个丑数
            if(++count >= n){
                return (int) cut;
            }
            for(int num : uglyNumber){
                //排除重复的数字
                if(! queue.contains(num * cut)){
                    queue.add(num * cut);
                }
            }
        }
        return -1;
    }
}

作者：YanShaoJiangHu
        链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/li-yong-xiao-gen-dui-wan-mei-jie-jue-by-yanshaojia/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//动态规划
class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}

作者：jyd
        链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        /**
         *定义三个指针p2,p3,p5，p2指向的数字永远乘2，p3指向的数字永远乘3，p5指向的数字永远乘5
         * 初始化所有指针都指向第一个丑数，即1
         * 我们从2*dp[p2], 3*dp[p3], 5*dp[p5]选取最小的一个数字，作为新的丑数。这边新的丑数就是2*dp[p2]=2*1=2，然后p2++
         * 此时p3和p5指向第1个丑数，p2指向第2个丑数。然后重复上一步
         * 这里基于的一个事实是，丑数数列是递增的，当p5指针在当前位置时，后面的数乘以5必然比前面的数乘以5大，所以下一个丑数必然是先考虑前面的数乘以5。p2,p3同理，所以才可以使用指针
         *
         * 作者：yuanninesuns
         * 链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/xiang-xi-jie-da-chao-jian-dan-bu-dong-zhao-wo-by-y/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        */
public int nthUglyNumber(int n) {
        int p2=0,p3=0,p5=0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
        dp[i]=Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
        if(dp[i]==dp[p2]*2) p2++;
        if(dp[i]==dp[p3]*3) p3++;
        if(dp[i]==dp[p5]*5) p5++;
        }
        return dp[n-1];
        }

        作者：yuanninesuns
        链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/xiang-xi-jie-da-chao-jian-dan-bu-dong-zhao-wo-by-y/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
