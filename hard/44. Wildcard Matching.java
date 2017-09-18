class Solution {
    public boolean isMatch(String s, String p) {
        int sPos = 0, pPos = 0, match = 0, starIdx = -1;            
        while (sPos < s.length()){
            // advancing both pointers
            if (pPos < p.length()  && (p.charAt(pPos) == '?' || s.charAt(sPos) == p.charAt(pPos))){
                sPos++;
                pPos++;
            }
            // * found, only advancing pattern pointer
            else if (pPos < p.length() && p.charAt(pPos) == '*'){
                starIdx = pPos;
                match = sPos;
                pPos++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                pPos = starIdx + 1;
                match++;
                sPos = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (pPos < p.length() && p.charAt(pPos) == '*')
            pPos++;
        
        return pPos == p.length();
        
    }
}