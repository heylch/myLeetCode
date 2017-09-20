class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        if(maxWidth == 0 || words.length == 0){
            result.add("");
            return result;
        }
        int len = 0;
        int wordInLine = 0;
        for(int i=0; i < words.length; i++){
            wordInLine++;
            len += words[i].length();
            while(i+1 < words.length && len + wordInLine -1 < maxWidth){
                i++;
                wordInLine++;
                len += words[i].length();
            }
            if(len + wordInLine -1 > maxWidth){
                len -= words[i].length();
                i--;
                wordInLine--;
            }
            StringBuilder line = new StringBuilder();
            if(i == words.length -1){
                int spaceNum = maxWidth - len;
                for(int j = i- wordInLine+1; j <=i; j++){
                    line.append(words[j]);
                    if(spaceNum > 0){
                        line.append(" ");
                        spaceNum--;
                    }
                        
                }
                int lineLength = line.length();
                for(int j = 0; j < spaceNum; j++)
                    line.append(" ");
            }
            else{
                int divSpace = 0;
                int extraSpaceNum = 0;
                if(wordInLine != 1){
                    divSpace = (maxWidth - len) / (wordInLine -1);
                    extraSpaceNum = (maxWidth - len) % (wordInLine -1);
                }
                else
                    extraSpaceNum = maxWidth - len;
                for(int j = i- wordInLine+1; j <=i; j++){
                    line.append(words[j]);
                    if (j != i){
                        for(int q = 0; q < divSpace ; q++)
                            line.append(" ");
                        if(extraSpaceNum >0){
                            line.append(" ");
                            extraSpaceNum--;
                        }
                    }
                    else{
                        if(extraSpaceNum >0){
                            for(int q = 0; q < extraSpaceNum; q++)
                                line.append(" ");
                        }
                    }
                }
            }
            wordInLine = 0;
            len = 0;
            result.add(line.toString());
        }
        return result;
    }
}