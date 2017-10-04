class WordDictionary {
    
    class TrieNode{
        char letter;
        TrieNode[] children;
        boolean isWord;
        
        TrieNode(){
            letter = ' ';
            children = new TrieNode[26];
            isWord = false;
        }
        
        TrieNode(char c){
            letter = c;
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode track = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(track.children[c-'a'] == null)
                track.children[c - 'a'] = new TrieNode(c);
            if(i == word.length() - 1)
                track.children[c - 'a'].isWord = true;
            track = track.children[c - 'a'];
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode track = root;
        boolean result = true;
        for(int i = 0; i < word.length() ;i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(int j=0; j < 26; j++){
                    if(track.children[j] !=null && i != word.length() -1){
                        if(searchHelper(track.children[j], i+1, word))
                            return true;
                    }
                    else if(track.children[j] !=null && i == word.length() -1 && track.children[j].isWord == true)
                        return true;
                }
                return false;
            }
            else{
                if(track.children[c-'a'] == null)
                    return false;
                if(i == word.length() -1 && track.children[c-'a'].isWord == false)
                    return false;
                track = track.children[c-'a'];
            }
        }
        return true;
    }
    
    private boolean searchHelper(TrieNode root, int pos, String word){
        if(pos == word.length())
            return true;
        TrieNode track = root;
        boolean result = true;
        for(int i = pos; i < word.length() ;i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(int j=0; j < 26; j++){
                    if(track.children[j] !=null && i != word.length() -1){
                        if(searchHelper(track.children[j], i+1, word))
                            return true;
                    }
                    else if(track.children[j] !=null && i == word.length() -1 && track.children[j].isWord == true)
                        return true;
                }
                return false;
            }
            else{
                if(track.children[c-'a'] == null)
                    return false;
                if(i == word.length() -1 && track.children[c-'a'].isWord == false)
                    return false;
                track = track.children[c-'a'];
            }
        }
        return true;
    }
}
