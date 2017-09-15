class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0 || board[0].length ==0)
            return false;
        int row = board.length;
        int col = board[0].length;
        boolean result = false;
        boolean left = false;
        boolean right = false;
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(board[i][j] == word.charAt(0)){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    set.add(list);
                    result = helper(i,j,1,set,board,word);
                    set.remove(list);
                }
                if(result == true)
                    return true;
            }
        }
        return result;
    }
    
    private boolean helper(int r, int c, int w, Set<List<Integer>> set, char[][] board, String word){
        boolean result = false;
        if(w == word.length())
            return true;
        if(r == board.length || c == board[0].length || r <0 || c <0)
            return false;
        set.add(Arrays.asList(r,c));
        if(!set.contains(Arrays.asList(r-1,c)) && r-1 >=0 && board[r-1][c] == word.charAt(w)){
            result = result || helper(r-1, c, w+1, set, board, word);
            if(result == true)
                return true;
        }
        if(!set.contains(Arrays.asList(r+1,c)) && r+1 < board.length  && board[r+1][c] == word.charAt(w)){
            result = result || helper(r+1, c, w+1, set,board, word);
            if(result == true)
                return true;
        }
        if(!set.contains(Arrays.asList(r,c-1)) && c- 1 >=0 && board[r][c-1] == word.charAt(w)){
            result = result || helper(r, c-1, w+1,set, board, word);
            if(result == true)
                return true;
        }
        if(!set.contains(Arrays.asList(r,c+1)) && c +1 < board[0].length && board[r][c+1] == word.charAt(w)){
            result = result || helper(r, c+1, w+1,set, board, word);
            if(result == true)
                return true;
        }
        set.remove(Arrays.asList(r,c));
        return false;
        
    }
}