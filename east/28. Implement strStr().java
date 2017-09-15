class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        int result = -1;
        int i = 0;
        int j = 0;
        while(i <= haystack.length() - needle.length()&& j < needle.length()){
            if(haystack.charAt(i) != needle.charAt(j))
                i++;
            else{
                int ii = i;
                while(ii <haystack.length() && j < needle.length() && haystack.charAt(ii) == needle.charAt(j)){
                    ii++;
                    j++;
                }
                if(j == needle.length()){
                    result = ii - needle.length();
                    return result;
                }
                else{
                    j = 0;
                    i++;
                }  
            }
        }
        return result;
    }
}