class Solution {
    // DFS
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length==0 || rooms[0].length ==0)
            return;
        int row = rooms.length;
        int col = rooms[0].length;
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(rooms[i][j] == 0)
                    helper(i,j,rooms,0);
            }
        }
    }
    
    private void helper(int x, int y, int[][] rooms,int val){
        int row = rooms.length;
        int col = rooms[0].length;
        if(x <0 || y <0 || x >= row || y >=col || rooms[x][y] < val)
            return;
        rooms[x][y] = val;
        helper(x-1,y,rooms,val+1);
        helper(x+1,y,rooms,val+1);
        helper(x,y-1,rooms,val+1);
        helper(x,y+1,rooms,val+1);
    }
    
    //BFS
    public void wallsAndGates(int[][] rooms){
        if(rooms.length ==0 || rooms[0].length == 0)
            return;
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i=0; i < rooms.length; i++){
            for(int j =0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    int[] coordination = {i,j};
                    queue.add(coordination);
                }
                    
            }
        }
        while(!queue.isEmpty()){
            int[] coord = queue.poll();
            int x = coord[0];
            int y = coord[1];
            if(x-1 >=0 && rooms[x-1][y] > rooms[x][y]+1){
                rooms[x-1][y] = rooms[x][y]+1;
                int[] coordination = {x-1,y};
                queue.add(coordination);
            }
            if(x+1 < row && rooms[x+1][y] > rooms[x][y]+1){
                rooms[x+1][y] = rooms[x][y]+1;
                int[] coordination = {x+1,y};
                queue.add(coordination);
            }
            if(y-1 >=0 && rooms[x][y-1] > rooms[x][y]+1){
                rooms[x][y-1] = rooms[x][y]+1;
                int[] coordination = {x,y-1};
                queue.add(coordination);
            }
            if(y+1 < col && rooms[x][y+1] > rooms[x][y]+1){
                rooms[x][y+1] = rooms[x][y]+1;
                int[] coordination = {x,y+1};
                queue.add(coordination);
            }
        }
    }
}