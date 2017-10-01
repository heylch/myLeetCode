class Solution {
    public boolean validPalindrome(String s) {
        if(s.length() == 0)
            return false;
        int start = 0;
        int end = s.length() -1;
        boolean change = true;
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else
                return helper(start+1, end, s) || helper(start, end-1, s);
        }
        return true;
    }
     private boolean helper(int start, int end, String s){
         while(start <=end){
             if(s.charAt(start) == s.charAt(end)){
                 start++;
                 end--;
             }
             else
                 return false;
         }
         return true;
     }
}