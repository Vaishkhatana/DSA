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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int levelsize  = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            int first = 0;
            while(levelsize-->0){
                
                TreeNode t = q.peek();
                q.poll();

                temp.add(first,t.val);
                first++;

                if(t.left!=null){
                    q.add(t.left);
                }

                if(t.right!=null){
                    q.add(t.right);
                }











            }
            res.add(temp);



        }
        return res;

        
    }
}