public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0)
            return true;
        return isMatchHelper(s,p,0,0);
    }
    
    private boolean isMatchHelper(String s, String p, int sPos, int pPos){
        if(pPos == p.length())
            return sPos == s.length() ;
        else if(sPos == s.length()){
            if(pPos +1 < p.length() && p.charAt(pPos +1) == '*')
                return isMatchHelper(s,p,sPos, pPos +2);
            else
                return false;
        }
        if(s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '.'){
            if(pPos +1 < p.length() && p.charAt(pPos +1) == '*'){
                if(isMatchHelper(s,p,sPos+1, pPos))
                    return true;
                else if(isMatchHelper(s,p,sPos+1, pPos+2))
                    return true;
                else
                    return isMatchHelper(s,p,sPos, pPos+2);
            }
            else{
                return isMatchHelper(s,p,sPos+1,pPos+1);
            }
        }
        else if(pPos +1 < p.length() && p.charAt(pPos + 1) == '*')
            return isMatchHelper(s,p,sPos, pPos+2);
        else
            return false;
    }