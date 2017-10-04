// recursion using bst featuring
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return helper(root.left,min,root.val) && helper(root.right, root.val,max);
    }
}

// recursion inorder
public class Solution {
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root){
        if(root == null)
            return true;
        boolean result = inorder(root.left);
        if(prev ==null)
            prev = root;
        else{
            if(root.val <= prev.val)
                return false;
            prev = root;
        }
        return result && inorder(root.right);
    }
}

// itineration inorder
public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        while(root !=null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if(prev == null)
                prev = node;
            else{
                if(node.val <= prev.val)
                    return false;
                prev = node;
            }
            root = node.right;
        }
        return true;
    }
}