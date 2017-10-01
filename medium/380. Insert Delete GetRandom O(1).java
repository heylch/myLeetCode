class RandomizedSet {
    private Map<Integer,Integer> valIndex;
    private Map<Integer,Integer> indexVal;
    int num;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valIndex = new HashMap<Integer,Integer>();
        indexVal = new HashMap<Integer,Integer>();
        num = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valIndex.containsKey(val))
            return false;
        else{
            num++;
            valIndex.put(val,num);
            indexVal.put(num,val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valIndex.containsKey(val))
            return false;
        else{
            int lastVal = indexVal.get(num);
            int numIndex = valIndex.get(val);
            indexVal.put(numIndex,lastVal);
            valIndex.put(lastVal,numIndex);
            valIndex.remove(val);
            indexVal.remove(num);
            num--;
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return indexVal.get(rand.nextInt(num)+1);
    }
}
