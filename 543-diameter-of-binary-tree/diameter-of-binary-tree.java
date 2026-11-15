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
    public  int n = -9999;
    int dia(TreeNode root){
        if(root==null) return 0;
         int leftHeight = dia(root.left);
        int rightHeight = dia(root.right);
        n = Math.max(n, leftHeight+rightHeight);
        return Math.max(leftHeight,rightHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
       
         dia(root);
        
       return n;
     
    }
}