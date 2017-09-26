// using inorder feature
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;
        TreeNode track = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean find = false;
        while(track != null || !stack.isEmpty()){
            while(track !=null){
                stack.push(track);
                track = track.left;
            }
            track = stack.pop();
            if(find)
                return track;
            if(track == p)
                find = true;
            track = track.right;
        }
        return null;
    }

//using BST feature && inorder feature    
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode result = null;
    while(root !=null){
        if(root.val > p.val){
            result = root;
            root = root.left;
        }
        else
            root = root.right;   
    }
    return result;
}