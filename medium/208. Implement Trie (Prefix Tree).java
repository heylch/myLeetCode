class Trie {
    private String letter;
    private List<Trie> children;
    private boolean end;
    /** Initialize your data structure here. */
    public Trie() {
        this.letter = "";
        this.children = new ArrayList<Trie>();
        boolean end = false;
    }
    
    public Trie(String letter) {
        this.letter = letter;
        this.children = new ArrayList<Trie>();
        this.end = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insertHelper(this, word, 0);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        boolean result = true;
        result = result && searchHelper(this, word, 0);
        return result;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0)
            return true;
        boolean result = false;
        for(Trie trie: children){
            if (trie.letter.equals(prefix.charAt(0) + "")){
                result = true && startsWithHelper(trie, prefix, 1);
                if(result == false)
                    return false;
            }
        }
        return result;
    }
    
    private boolean startsWithHelper(Trie trie, String prefix, int pos){
        if(pos == prefix.length())
            return true;
        boolean result = false;
        for(Trie child: trie.children){
            if(child.letter.equals(prefix.charAt(pos) + "")){
                result = true && startsWithHelper(child, prefix, pos +1);
                if(result == false)
                    return false;
            }   
        }
        return result;
    }
    
    private void insertHelper(Trie trie, String word, int pos){
        boolean has = false;
        if(pos == word.length())
            return;
        int len = trie.children.size();
        for(int i=0; i < len; i++){
            Trie child = trie.children.get(i);
            if(child.letter.equals(word.charAt(pos) + "")){
                has = true;
                if(pos == word.length()-1){
                    if(child.end == false){
                        child.end = true;
                    }
                }
                insertHelper(child, word, pos+1);
            }
        }
        if(!has)
            create(trie,word,pos);
    }
    
    private void create(Trie parent, String word, int pos){
        if(pos == word.length())
            return;
        Trie child = new Trie(word.charAt(pos) + "");
        if(pos == word.length() -1)
            child.end = true;
        parent.children.add(child);
        create(child, word, pos+1);
    }
    
    private boolean searchHelper(Trie trie, String word, int pos){
        if(pos == word.length() && trie.children.size() == 0)
            return true;
        else if(pos == word.length())
            return false;
        boolean result = false;
        for(Trie child: trie.children){
            if(child.letter.equals(word.charAt(pos) + "")){
                if(pos == word.length() -1){
                    if(child.end == true)
                        return true;
                    else
                        return false;
                }
                result = true && searchHelper(child, word, pos +1);
                if(result == false)
                    return false;
            }
                
        }
        return result;
    }
}x