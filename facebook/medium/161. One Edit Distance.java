class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() - t.length() >=2 || s.length() - t.length()<=-2 || s.equals(t))
            return false;
        int i= 0;
        int j = 0;
        boolean change = false;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else if(!change && s.charAt(i) != t.charAt(j)){
                if(s.length() > t.length())
                    i++;
                else if(s.length() < t.length())
                    j++;
                else{
                    i++;
                    j++;
                }
                change = true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}