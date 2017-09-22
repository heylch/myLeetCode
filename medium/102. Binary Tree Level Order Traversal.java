class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            List<Integer> layer = new ArrayList<Integer>();
            while(queue.peek() != null){
                TreeNode node = queue.poll();
                layer.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(layer);
            if(queue.peek() == null)
                queue.poll();
            if(!queue.isEmpty())
                queue.add(null);
        }
        return result;
    }
}