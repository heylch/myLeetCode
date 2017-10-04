class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    result ++;
                    helper(i,j,grid);
                }
            }
        }
        return result;
    }
    
    private void helper(int i, int j, char[][]grid){
        if(i <0 || i >= grid.length || j <0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        helper(i-1,j,grid);
        helper(i+1,j,grid);
        helper(i,j-1,grid);
        helper(i,j+1,grid);
    }
}
