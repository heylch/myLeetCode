class WordDictionary {
    private WordDictionary[] children;
    private boolean isWord;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.children = new WordDictionary[26];
        this.isWord = false;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary parent = this;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(parent.children[c - 'a'] == null){
                WordDictionary w = new WordDictionary();
                parent.children[c - 'a'] = w;
            }
            parent =  parent.children[c - 'a'];    
        }
        parent.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(this, word, 0);
    }
    
    private boolean searchHelper(WordDictionary parent, String word, int pos){
        boolean result = true;
        if(pos == word.length() && parent.isWord == true)
            return true;
        else if(pos == word.length())
            return false;
        
        if (word.charAt(pos) == '.'){
            for(WordDictionary child: parent.children){
                if(child != null && searchHelper(child, word, pos+1))
                    return true;
            }
            return false;
        }
        else{
            char c = word.charAt(pos);
            WordDictionary child = parent.children[c - 'a'];
            return child != null && searchHelper(child, word, pos+1);
        }
    }
}