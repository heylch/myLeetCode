class Solution {
    public int maximumSwap(int num) {
        String str = num + "";
        int i = 0;
        char[] numc = str.toCharArray();
        while(i+1 < numc.length && numc[i] >= numc[i+1])
            i++;
        if(i == numc.length -1)
            return num;
        int index1 = i;
        i++;
        int index2 = i;
        char max = numc[i];
        while(i < numc.length){
            if(numc[i] >= max){
                max = numc[i];
                index2 = i;
            }
            i++;
        }
        for(int j=0; j <= index1; j++){
            if(numc[j] < max){
                numc[index2] = numc[j];
                numc[j] = max;
                break;
            }
        }
        int result =0;
        for(int j=0; j < numc.length; j++)
            result = result*10 + (numc[j] - '0');
        return result;
    }
}