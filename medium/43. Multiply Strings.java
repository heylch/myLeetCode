class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() ==0)
            return "";
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int carryBit = 0;
        String longStr = (num1.length() >= num2.length()) ? num1:num2;
        String shortStr = (num1.length() < num2.length()) ? num1:num2;
        String result = "";
        int i = 0;
        int j =0;
        while(i < longStr.length() && j < shortStr.length()){
            int sum = carryBit;
            int n = j;
            while(n < shortStr.length()){
                if(longStr.length()-1-i+n-j < longStr.length())
                    sum += (shortStr.charAt(shortStr.length()-1-n)- '0') * (longStr.charAt(longStr.length()-1-i+n-j)- '0');
                n++;
            }
            carryBit = sum /10;
            int digit = sum %10;
            result = digit + result;
            if(i == longStr.length()-1 )
                j++;
            if(i < longStr.length() -1)
                i++;
        }
        if(carryBit > 0){
            result = carryBit + result;
        }
            
        return result;
    }
}