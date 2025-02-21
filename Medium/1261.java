//Find Elements in a Contaminated Binary Tree
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
class FindElements {
    HashSet<Integer> st = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;

        st.add(0);

        solve(root.left , 0 , true);
        solve(root.right , 0 , false);
    }
    
    public boolean find(int target) {
        return st.contains(target);
    }

    public void solve(TreeNode root , int ele , boolean isLeft){
        if(root == null){
            return;
        }

        root.val = (isLeft == true ? (2 * ele + 1) : (2 * ele + 2));
        st.add(root.val);

        if(root.left != null){
            solve(root.left , root.val , true);
        }

        if(root.right != null){
            solve(root.right , root.val , false);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */