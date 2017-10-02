// n*mlgm
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String,List<String>>();
        for(String str: strs){
            char[] c= str.toCharArray();
            Arrays.sort(c);
            String strKey = String.valueOf(c);
            if(map.containsKey(strKey)){
                List<String> list = map.get(strKey);
                list.add(str);
                map.put(strKey, list);
            }
            else{
                List<String>list = new ArrayList<String>();
                list.add(str);
                map.put(strKey,list);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>(map.values());
        return result;
    }
}

//n*m 这种方法如果string过长的话有可能有overflow的问题
//还有种n*m的方法是：存一个int[26]的数组，对应每个char的数量，然后再把这个数组合成一个string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = new int[]{2, 3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};
        Map<Long, List<String>> map = new HashMap<Long,List<String>>();
        for(String str: strs){
            long count = 1;
            for(int i=0; i < str.length(); i++){
                count *= primes[str.charAt(i)-'a'];
            }
            if(map.containsKey(count)){
                List<String> list = map.get(count);
                list.add(str);
                map.put(count, list);
            }
            else{
                List<String>list = new ArrayList<String>();
                list.add(str);
                map.put(count,list);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>(map.values());
        return result;
    }
}