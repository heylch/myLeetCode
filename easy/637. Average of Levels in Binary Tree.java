class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            long sum =0;
            int len = queue.size();
            for(int i=0; i < len; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(sum/(double)len);
        }
        return result;
    }
}