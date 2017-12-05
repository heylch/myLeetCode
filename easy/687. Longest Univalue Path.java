//687. Longest Univalue Path
class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        int local = helper(root);
        return max;
    }
    
    private int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int localMax = 0;
        if(root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val){
            localMax = Math.max(left,right) +1;
            max = Math.max(max,right + left +2);
        }
        else if(root.left != null && root.val == root.left.val){
            localMax = left +1;
            max = Math.max(max,localMax);
        }
        else if (root.right != null && root.val == root.right.val){
            localMax = right +1;
            max = Math.max(localMax, max);
        }
        return localMax;
    }
}