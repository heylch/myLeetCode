class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = helper(root, 0);
        return sum;
    }
    
    private int helper(TreeNode root, int number){
        if(root == null)
            return 0;
        number = number*10 + root.val;
        if(root.left == null && root.right == null)
            return number;
        int sum = helper(root.left,number) + helper(root.right,number);
        return sum;
    }
}