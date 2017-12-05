//686. Repeated String Match
// KMP O(m+n)
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int[] partialMatch = new int[B.length()];
        for(int m = 0; m < B.length(); m++){
            if(m-1 >=0 && partialMatch[m-1] != 0 && B.charAt(partialMatch[m-1]) == B.charAt(m))
                partialMatch[m] = partialMatch[m-1]+1;
            else if(m!=0 && B.charAt(m) == B.charAt(0))
                partialMatch[m] = 1;
        }
        int i= 0;
        int j = 0;
        int num =1;
        while(i < A.length()){
            if(A.charAt(i) == B.charAt(j)){
                while(j < B.length() && i < A.length() && A.charAt(i) == B.charAt(j)){
                    i++;
                    j++;
                    if(j == B.length())
                        return num;
                    if(i == A.length()){
                        i = 0;
                        num++;
                    }
                }
            }
            else{
                if(partialMatch[j] !=0){
                    j = partialMatch[j]-1;
                }
                else{
                    j =0;
                    if(j == 0 && i == 0 && num >1)
                        return -1;
                    i++;
                }
            }
        }
        return -1;
    }
}


// O(m*n)
// class Solution {
//     public int repeatedStringMatch(String A, String B) {
//         for(int i = 0; i < A.length(); i++){
//             int j = 0;
//             while(j < B.length() && A.charAt((i+j)%A.length()) == B.charAt(j))
//                 j++;
//             if(j == B.length())
//                 return (int)Math.ceil((i+j)/(double)A.length());
//         }
//         return -1;
//     }
// }