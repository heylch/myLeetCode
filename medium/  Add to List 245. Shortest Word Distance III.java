public int shortestWordDistance(String[] words, String word1, String word2) {
        Integer index1 = null;
        Integer index2 = null;
        int result = Integer.MAX_VALUE;
        for(int i=0; i < words.length; i++){
            if(words[i].equals(word1)){
                if(word1.equals(word2)){
                    index1 = index2;
                    index2 = i;
                }
                else
                    index1 = i;
            }
            else if(words[i].equals(word2))
                index2 = i;
            if(index1 != null && index2 != null)
                result = Math.min(result, Math.abs(index2 - index1));
        }
        return result;
    }