public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i =1; i < s.length() ;i++){
            int first = s.charAt(i-1)-'0';
            int second = s.charAt(i)-'0';
            if(second == 0){
                if(first*10+second <=26 && first*10+second >=10)
                    dp[i+1] = dp[i-1];
                else
                    return 0;
            }
            else{
                dp[i+1] = dp[i];
                if(first*10+second <=26 && first*10+second >=10)
                    dp[i+1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }
}