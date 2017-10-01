// Traverse first then find
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null || (root.left == null && root.right == null))
            return false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> nums = new ArrayList<Integer>();
        // stack.push(root);
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            nums.add(node.val);
            if(node.right != null){
                node = node.right;
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        int start = 0;
        int end = nums.size()-1;
        while(start < end){
            int small = nums.get(start);
            int big = nums.get(end);
            if(small + big == k)
                return true;
            else if(small + big < k)
                start++;
            else
                end--;
        }
        return false;
    }
}

// while traversing while finding
class Solution{
    public boolean findTarget(TreeNode root, int k) {
        if(root == null || (root.left == null && root.right == null))
            return false;
        Set<Integer> set = new HashSet<Integer>();
        set.add(root.val);
        return helper(root.left,k,set) || helper(root.right,k,set);
    }
    
    private boolean helper(TreeNode root, int k, Set<Integer> set){
        if(root == null)
            return false;
        if(set.contains(k - root.val))
            return true;
        set.add(root.val);
        return helper(root.left,k,set) || helper(root.right,k,set);
    }
}