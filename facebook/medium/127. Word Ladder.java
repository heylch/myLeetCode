class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<String>();
        Set<String> wordDic = new HashSet<String>(wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        visited.add(beginWord);
        int result = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            result++;
            for(int j=0; j < len; j++){
                String word = queue.poll();
                for(int i=0; i < beginWord.length(); i++){
                    char[] str = word.toCharArray();
                    for(int m =0; m < 26; m++){
                        str[i] = (char)('a'+m);
                        String newWord = new String(str);
                        if(wordDic.contains(newWord) && !visited.contains(newWord)){
                            if(newWord.equals(endWord))
                                return result+1;
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
