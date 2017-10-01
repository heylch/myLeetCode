// Recursion O(n^2)
class Solution {
    public int countSubstrings(String s){
        if(s.length() ==0)
            return 0;
        int result =0;
        for(int i=0; i < s.length(); i++){
            result += helper(i,i,s);
            result += helper(i,i+1,s);
        }
        return result;
    }
    
    private int helper(int start, int end, String s){
        if(end >= s.length())
            return 0;
        int result = 0;
        while(start>=0 && end < s.length() && start <= end && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            result++;
        }
        return result;
    }
}

//DP O(n^2)
class Solution{
    public int countSubstrings(String s) {
        if(s.length() ==0)
            return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for(int i=0; i < s.length(); i++){
            for(int j=0; j <=i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i ==j || j== i-1){
                        dp[j][i] = true;
                        result++;
                    }
                    else if(j < i-1){
                        if(dp[j+1][i-1]){
                           dp[j][i] = true;
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}