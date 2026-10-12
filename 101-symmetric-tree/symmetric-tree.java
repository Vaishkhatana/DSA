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
    public boolean isSymmetric(TreeNode root) {
        return ans(root.left, root.right);
        
    }


    public  boolean ans(TreeNode a , TreeNode b){
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }

        if(a.val != b.val){
            return false;
        }

        boolean r1 = ans(a.left,b.right);
        boolean r2 = ans(a.right,b.left);

        return r1&&r2;
    }
}