class Trie {
    class TrieNode{
        char letter;
        boolean isWord;
        TrieNode[] children;
        public TrieNode(){
            letter = ' ';
            children = new TrieNode[26];
            isWord = false;
        }
        
        public TrieNode(char c){
            letter = c;
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode track = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(track.children[c-'a'] == null)
                track.children[c-'a'] = new TrieNode(c);
            if(i == word.length()-1)
                track.children[c-'a'].isWord = true;
            track = track.children[c-'a'];
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode track = root;
        for(int i = 0; i < word.length(); i++){
            char c= word.charAt(i);
            if(track.children[c-'a'] == null)
                return false;
            else{
                if(i == word.length() -1 && track.children[c-'a'].isWord == false)
                    return false;
                else
                    track = track.children[c-'a'];
            }
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode track = root;
        for(int i = 0; i < prefix.length(); i++){
            char c= prefix.charAt(i);
            if(track.children[c-'a'] == null)
                return false;
            else
                track = track.children[c-'a'];
        }
        return true;
    }
}
