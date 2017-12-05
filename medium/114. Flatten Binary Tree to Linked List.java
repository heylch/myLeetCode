class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        helper(root,queue);
        queue.poll();
        TreeNode track = root;
        while(!queue.isEmpty()){
            track.left = null;
            track.right = queue.poll();
            track = track.right;
        }
    }
    
    private void helper(TreeNode root, Queue<TreeNode> queue){
        if(root == null)
            return;
        queue.add(root);
        helper(root.left,queue);
        helper(root.right,queue);
    }
}