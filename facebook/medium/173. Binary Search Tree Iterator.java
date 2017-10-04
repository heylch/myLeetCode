public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root !=null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int next() {
        int result = 0;
        TreeNode node = null;
        if(!stack.isEmpty()){
            node = stack.pop();
            result = node.val;
            node = node.right;
            while(node !=null){
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}
