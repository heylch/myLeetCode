class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> col = new LinkedList<Integer>();
        queue.add(root);
        col.add(0);
        int minCol = 0;
        int maxCol = 0;
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int colIndex = col.poll();
            if(!map.containsKey(colIndex)){
                List<Integer> list = new ArrayList<Integer>();
                list.add(node.val);
                map.put(colIndex,list);
            }
            else{
                List<Integer> list = map.get(colIndex);
                list.add(node.val);
                map.put(colIndex, list);
            }
            if(node.left != null){
                queue.add(node.left);
                col.add(colIndex-1);
                minCol = Math.min(minCol,colIndex-1);
            }
            if(node.right != null){
                queue.add(node.right);
                col.add(colIndex+1);
                maxCol = Math.max(maxCol,colIndex+1);
            }
        }
        for(int i = minCol; i <= maxCol; i++)
            result.add(map.get(i));
        return result;
    }
}