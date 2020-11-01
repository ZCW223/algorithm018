package Week02;

public class _9TheTopKElements {
}
/**给定一个非空的整数数组，返回其中出现频率前k高的元素。



 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]


 提示：

 你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 你的算法的时间复杂度必须优于 O(n log n) ,n是数组的大小。
 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 你可以按任意顺序返回答案。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

方法一：堆
        思路与算法

        首先遍历整个数组，并使用哈希表记录每个数字出现的次数，并形成一个「出现次数数组」。找出原数组的前 kk 个高频元素，就相当于找出「出现次数数组」的前 kk 大的值。

        最简单的做法是给「出现次数数组」排序。但由于可能有 O(N)O(N) 个不同的出现次数（其中 NN 为原数组长度），故总的算法复杂度会达到 O(N\log N)O(NlogN)，不满足题目的要求。

        在这里，我们可以利用堆的思想：建立一个小顶堆，然后遍历「出现次数数组」：

        如果堆的元素个数小于 kk，就可以直接插入堆中。
        如果堆的元素个数等于 kk，则检查堆顶与当前出现次数的大小。如果堆顶更大，说明至少有 kk 个数字的出现次数比当前值大，故舍弃当前值；否则，就弹出堆顶，并将当前值插入堆中。
        遍历完成后，堆中的元素就代表了「出现次数数组」中前 kk 大的值。

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}

作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        方法二：基于快速排序
        思路与算法

        我们可以使用基于快速排序的方法，求出「出现次数数组」的前 kk 大的值。

        在对数组 \textit{arr}[l \ldots r]arr[l…r] 做快速排序的过程中，我们首先将数组划分为两个部分 \textit{arr}[i \ldots q-1]arr[i…q−1] 与 \textit{arr}[q+1 \ldots j]arr[q+1…j]，并使得 \textit{arr}[i \ldots q-1]arr[i…q−1] 中的每一个值都不超过 \textit{arr}[q]arr[q]，且 \textit{arr}[q+1 \ldots j]arr[q+1…j] 中的每一个值都大于 \textit{arr}[q]arr[q]。

        于是，我们根据 kk 与左侧子数组 \textit{arr}[i \ldots q-1]arr[i…q−1] 的长度（为 q-iq−i）的大小关系：

        如果 k \le q-ik≤q−i，则数组 \textit{arr}[l \ldots r]arr[l…r] 前 kk 大的值，就等于子数组 \textit{arr}[i \ldots q-1]arr[i…q−1] 前 kk 大的值。
        否则，数组 \textit{arr}[l \ldots r]arr[l…r] 前 kk 大的值，就等于左侧子数组全部元素，加上右侧子数组 \textit{arr}[q+1 \ldots j]arr[q+1…j] 中前 k - (q - i)k−(q−i) 大的值。
        原版的快速排序算法的平均时间复杂度 为 O(N\log N)O(NlogN)。我们的算法中，每次只需在其中的一个分支递归即可，因此算法的平均时间复杂度降为 O(N)O(N)。

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}

作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。