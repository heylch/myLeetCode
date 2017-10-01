class Solution {
    //iteration
    public List<String> letterCombinations(String digits) {
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> result = new LinkedList<String>();
        if(digits.length() == 0)
            return result;
        result.add("");
        for(int i=0; i < digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            int len = result.size();
            for(int m =0; m < len; m++){
                String s = result.poll();
                for(int j=0; j < letters[digit].length(); j++){
                    char c = letters[digit].charAt(j);
                    result.add(s + c);
                }
            }
        }
        return result;
    }
    
    //recursion
    public List<String> letterCombinations(String digits) {
        String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<String>();
        if(digits.length() ==0)
            return result;
        combination("", digits, 0, result, letters);
        return result;
    }

    private void combination(String prefix, String digits, int pos, List<String> result, String[] letters) {
        if (pos >= digits.length()) {
            result.add(prefix);
            return;
        }
        String letter = letters[(digits.charAt(pos) - '0')];
        for (int i = 0; i < letter.length(); i++) {
            combination(prefix + letter.charAt(i), digits, pos + 1, result, letters);
        }
    }
}