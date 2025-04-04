//Lowest Common Ancestor of Deepest Leaves
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDepth = 0;
    HashMap<Integer , Integer> mp;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        mp = new HashMap<>();
        checkDepth(root , 0);

        return LCA(root);
    }

    public TreeNode LCA(TreeNode root){
        if(root == null || mp.get(root.val) == maxDepth){
            return root;
        }

        TreeNode l = LCA(root.left);
        TreeNode r = LCA(root.right);

        if(l != null && r != null){
            return root;
        }

        return l != null ? l : r;
    }

    public void checkDepth(TreeNode root , int d){
        if(root == null){
            return;
        }

        maxDepth = Math.max(maxDepth , d);
        mp.put(root.val , d);

        checkDepth(root.left , d+1);
        checkDepth(root.right , d+1);
    }
}