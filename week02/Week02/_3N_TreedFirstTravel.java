package Week02;

//import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _3N_TreedFirstTravel {

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
//1.迭代法
    public static LinkedList<Integer> preorder(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root == null){
             return output;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for(Node item : node.children){
                stack.add(item);
            }
        }
        return output;
    }
//2.递归
ArrayList<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorder1(Node root) {
        dfs(root);
        return res;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node child: root.children) {
            dfs(child);
        }
    }

//    作者：yi-wen-statistics
//    链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/589ncha-shu-de-qian-xu-bian-li-duo-jie-by-yi-wen-s/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
