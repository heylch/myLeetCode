class Solution {
    public String numberToWords(int num){
        StringBuilder result = new StringBuilder();
        int threeDigit = num % 1000;
        String word = convertHundred(threeDigit);
        if(word.length() != 0)
            result.append(word);
        String[] unit = {"Thousand", "Million", "Billion"};
        num /= 1000;
        int i = 0;
        while(num>0){
            threeDigit = num %1000;
            word = convertHundred(threeDigit);
            num /= 1000;
            if(word.length() !=0){
                if(result.length() == 0)
                    result.insert(0,unit[i]);
                else
                    result.insert(0,unit[i]+ " ");
                result.insert(0,word+ " ");
            }
            i++;
        }
        if(result.length() == 0)
            result.append("Zero");
        return result.toString();
    }
    
    private String convertHundred(int num){
        String[] tens = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
                           "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] twenty = {"Twenty", "Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        int a = num/100;
        int c = num %10;
        int b = (num %100)/10;
        StringBuilder word = new StringBuilder();
        if(a >0){
            word.append(tens[a-1]+" ");
            word.append("Hundred");
        }
        if(b == 1){
            if(word.length() != 0)
                word.append(" ");
            word.append(tens[num%100 -1]);
        }
        else if(b > 0){
            if(word.length() != 0)
                word.append(" ");
            word.append(twenty[b-2]);
        }
        if(b != 1 && c !=0){
            if(word.length() != 0)
                word.append(" ");
            word.append(tens[c-1]);
        }
        return word.toString();
    }