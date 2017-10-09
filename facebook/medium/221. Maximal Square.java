public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length ==0 || matrix[0].length == 0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        for(int i = 0; i < matrix[0].length; i++){
            dp[0][i] = matrix[0][i] - '0';
            if(dp[0][i] == 1)
                maxLen = 1;
        }
        for(int i = 0; i < matrix.length; i++){
            dp[i][0] = matrix[i][0] - '0';
            if(dp[i][0] == 1)
                maxLen = 1;
        }
            
        for(int i= 1; i < matrix.length; i++){
            for(int j=1; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]) +1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}