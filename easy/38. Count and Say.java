class Solution {
    public String countAndSay(int n) {
        if(n<=0)
            return "";
        String result = "1";
        for(int i =1; i < n; i++){
            String str = "";
            for(int j=0; j < result.length(); j++){
                int num = 1;
                while(j+1 < result.length() && result.charAt(j) == result.charAt(j+1)){
                    num++;
                    j++;
                }
                str = str + num + result.charAt(j);
            }
            result = str;
        }
        return result;
    }
}