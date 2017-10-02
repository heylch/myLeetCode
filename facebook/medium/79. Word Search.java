class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[row][col];
        for(int i =0; i < row; i++){
            for(int j =0; j < col; j++){
                if(dfs(i,j,0,chars,board,visited))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, int pos, char[] chars, char[][] board, boolean[][] visited){
        int row = board.length;
        int col = board[0].length;
        if(pos == chars.length)
            return true;
        if(i < 0 || i >= row || j < 0 || j >= col)
            return false;
        if(board[i][j] != chars[pos])
            return false;
        if(visited[i][j] == true)
            return false;
        visited[i][j] = true;
        if(dfs(i+1, j, pos+1,chars,board,visited))
            return true;
        if(dfs(i-1, j, pos+1,chars,board,visited))
            return true;
        if(dfs(i, j+1, pos+1,chars,board,visited))
            return true;
        if(dfs(i, j-1, pos+1,chars,board,visited))
            return true;
        visited[i][j] = false;
        return false;   
    }
}