class Solution {
    public String numberToWords(int num) {
        String[] single = {"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight","Nine"};
        String[] ten = {"Ten", "Eleven","Twelve", "Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] two = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] unit = {"Hundred","Thousand","Million","Billion"};
        StringBuilder result = new StringBuilder();
        StringBuilder number = new StringBuilder();
        String numstr = num+"";
        for(int i = 0; i < numstr.length(); i++){
            number.insert(0, numstr.charAt(numstr.length()-1-i));
            if((i+1) % 3 ==0 && numstr.length()-1-i>=0){
                number.insert(0, ",");
            }
        }
        String[] nums = number.toString().split(",");
        for(int i=0; i < nums.length; i++){
            int diff = 0;
            String n = nums[nums.length-1-i];
            if(n.length() == 0)
                break;
            if(i!=0 && n.length()!=0){
                if(result.length() !=0){
                    result.insert(0, unit[i] + " ");
                    diff = unit[i].length() +1;
                }
                    
                else{
                    result.insert(0, unit[i]);
                    diff = unit[i].length();
                }
                    
            }
            int j =0;
            
            int len = n.length();
            int prevlen = result.length();
            while(j < len){
                if(len == 1 && n.charAt(0) == '0')
                    result.insert(0,"Zero");
                else if(n.length() ==3 && j ==2 && n.charAt(0) != '0'){
                    if(i==0 && len ==3 && n.charAt(1) == '0' && n.charAt(2) == '0')
                        result.insert(0,"Hundred");
                    else
                        result.insert(0,"Hundred ");
                    result.insert(0,single[n.charAt(len-3) - '0']+ " ");
                    
                }
                else if(j == 0){
                    if(len >=2 && n.charAt(len-2) =='1'){
                        if(i == 0)
                            result.insert(0,ten[n.charAt(len-1) - '0']);
                        else
                            result.insert(0,ten[n.charAt(len-1) - '0'] + " ");
                        j++;
                    }
                    else if (n.charAt(len-1) != '0'){
                        if(i == 0)
                            result.insert(0, single[n.charAt(len-1) - '0']);
                        else
                            result.insert(0, single[n.charAt(len-1) - '0'] + " ");
                    }
                }
                else if(n.length() >=2 && j == 1 && n.charAt(len-2) != '0' && n.charAt(len-2) != '1'){
                    if(i == 0 && n.charAt(len-1) == '0')
                        result.insert(0,two[n.charAt(len-2) - '2']);
                    else
                        result.insert(0,two[n.charAt(len-2) - '2'] + " ");
                }
                j++;
            }
            if(result.length() == prevlen && result.length() !=0)
                result = new StringBuilder(result.substring(diff,result.length()));
        }
        return result.toString();
    }
}