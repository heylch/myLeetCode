class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int hindex = 0;
        for(int i=0; i < citations.length; i++){
            if(citations[i] >= citations.length - i)
                return citations.length - i;
        }
        return hindex;
    }
}