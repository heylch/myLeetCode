public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size() == 0)
            return false;
        Boolean[] check = new Boolean[s.length()];
        return helper(s,0,wordDict, check);
    }
    
    private boolean helper(String s, int start, List<String>wordDict, Boolean[] check){
        if(start == s.length())
            return true;
        if(check[start] != null)
            return check[start];
        for(int i= start+1; i <= s.length(); i++){
            String piece = s.substring(start,i);
            if(wordDict.contains(piece)){
                check[start] = helper(s,i,wordDict,check);
                if(check[start] == true)
                    return true;
            } 
        }
        check[start] = false;
        return check[start];
    }
}