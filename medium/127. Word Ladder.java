class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>();
        for(String w: wordList)
            set.add(w);
        int len = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);
        while(!queue.isEmpty()){
            String word = queue.poll();
            if(word == null){
                if(queue.isEmpty())
                    return 0;
                len ++;
                queue.add(null);
                continue;
            }
            if(word.equals(endWord))
                return len+1;
            int l = word.length();
            for(int i=0; i < l; i++){
                for(int j=0; j < 26; j++){
                    String newWord = word.substring(0,i) + (char)('a' + j)+word.substring(i+1, l);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        queue.add(newWord);
                    }
                }
            }
        }
        return 0;
    }
}