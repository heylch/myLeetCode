class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i=0; i < strs.length; i++){
            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyStr = String.valueOf(c);
            if(map.containsKey(keyStr)){
                List<String> list = map.get(keyStr);
                list.add(s);
                map.put(keyStr, list);
            }
            else{
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(keyStr, list);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>(map.values());
        return result;
    }
}