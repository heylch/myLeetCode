class Solution {
    public String multiply(String num1, String num2) {
        int[] digits = new int[num1.length() + num2.length()];
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int carryBit = 0;
        for(int i = num1.length()-1; i >=0; i--){
            for(int j = num2.length()-1; j >=0; j--){
                int product = (num2.charAt(j) - '0')*(num1.charAt(i)  - '0');
                digits[i+j+1] += product;
                digits[i+j] += digits[i+j+1] / 10;
                digits[i+j+1] = digits[i+j+1] % 10;
            }
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < digits.length && digits[i] == 0)
            i++;
        while(i < digits.length){
            result.append(digits[i]);
            i++;
        }
        return result.toString();
    }
}