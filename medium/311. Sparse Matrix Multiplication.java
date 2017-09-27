class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A.length ==0 || B.length==0 || A[0].length==0 || B[0].length == 0)
            return new int[0][0];
        int row = A.length;
        int col = B[0].length;
        int colA = A[0].length;
        int[][] result = new int[row][col];
        for(int i=0; i < row; i++){
            for(int n = 0; n < colA; n++){
                if(A[i][n] !=0){
                    for(int j=0; j < col; j++)
                        result[i][j] += A[i][n] * B[n][j];
                }
            }
        }
        return result;
    }
}