class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n != 0){
            n = n-1;
            result.insert(0,(char)('A' + n % 26 ));
            n = n/26;
        }
        return result.toString();
    }
}