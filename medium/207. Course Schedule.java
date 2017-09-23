class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return true;
        if(prerequisites.length == 0 || prerequisites[0].length == 0)
            return true;
        boolean result = false;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for(int i=0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            if(map.containsKey(course)){
                List<Integer> pre = map.get(course);
                pre.add(prerequisites[i][1]); 
                map.put(course,pre);
            }
            else{
                List<Integer> pre = new ArrayList<Integer>();
                pre.add(prerequisites[i][1]);
                map.put(course, pre);
            }
            visited.put(course,false);
        }
        numCourses = map.size();
        for(int i=0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            if(!visited.isEmpty() && visited.containsKey(course) && visited.get(course))
                continue;
            numCourses -= checkPre(course, map,visited,0);
            if(numCourses <=0)
                return true;
        }
        return result;
    }
    
    private int checkPre(int course, Map<Integer, List<Integer>>map, Map<Integer, Boolean>visited, int num){
        if(map.isEmpty() || !map.containsKey(course))
            return 1;
        if(!visited.isEmpty() && visited.containsKey(course) && visited.get(course))
            return 0;
        visited.put(course, true);
        int take = 0;
        for(Integer prev: map.get(course)){
            int check = checkPre(prev, map, visited, num);
            if(check == 0)
                return num;
            take += check;
        }
        num +=take;
        map.remove(course);
        visited.remove(course);
        return num;  
    }
}