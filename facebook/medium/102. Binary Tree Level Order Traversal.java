// iteration using queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i=0; i < len; i++){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                level.add(node.val);
            }
            result.add(level);
        }
        return result;
    }
}

// recursion
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        helper(root, result, 0);
        return result;
    }
    
    private void helper(TreeNode root, List<List<Integer>> result, int level){
        if(root == null)
            return;
        if(level >= result.size()){
            List<Integer> newLevel = new ArrayList<Integer>();
            newLevel.add(root.val);
            result.add(newLevel);
        }
        else{
            List<Integer> existLevel = result.get(level);
            existLevel.add(root.val);
        }
        helper(root.left, result,level+1);
        helper(root.right, result,level+1);
            
    }
}