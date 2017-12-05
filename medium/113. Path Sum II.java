class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        List<Integer> path = new ArrayList<Integer>();
        helper(root,sum,path,result);
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result){
        if(root == null)
            return;
        path.add(root.val);
        if(root.val == sum && root.left == null && root.right == null){
            List<Integer> onePath = new ArrayList<Integer>(path);
            result.add(onePath);
        }
        helper(root.left,sum-root.val,path,result);
        helper(root.right,sum-root.val,path,result);
        path.remove(path.size()-1);
    }
}