public List<String> letterCombinations(String digits) {
        String[] alphabet = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> result = new <String>LinkedList();
        if(digits.length() == 0)
            return result;
        result.add("");
        for(int i =0; i < digits.length(); i++){
            char c = digits.charAt(i);
            String s = alphabet[c-'0'];
            int curLen = result.size();
            for(int j=0; j < curLen; j++){
                String str = result.removeFirst();
                for(int m = 0; m < s.length(); m++){
                    String newStr = str + s.charAt(m) + "";
                    result.add(newStr);
                }
            }
        }
        
        return result;
    }