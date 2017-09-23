class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    result++;
                    checkAround(i,j,grid,visited);
                }
            }
        }
        return result;
    }
    
    private void checkAround(int x, int y, char[][] grid, boolean[][] visited){
        if(x <0 || x>= grid.length || y <0 || y>=grid[0].length)
            return;
        if(visited[x][y] || grid[x][y] == '0')
            return;
        visited[x][y] = true;
        checkAround(x-1,y,grid,visited);
        checkAround(x+1,y,grid,visited);
        checkAround(x,y-1,grid,visited);
        checkAround(x,y+1,grid,visited);
    }
}