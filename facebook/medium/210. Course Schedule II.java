// DFS
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        List<Integer> order = new ArrayList<Integer>();
        boolean[] visited = new boolean[numCourses];
        boolean[] take = new boolean[numCourses];
        for(int i=0; i < prerequisites.length; i++){
            int c1 =  prerequisites[i][0];
            int c2 =  prerequisites[i][1];
            if(map.containsKey(c1)){
                List<Integer> prevc = map.get(c1);
                prevc.add(c2);
                map.put(c1,prevc);
            }
            else{
                List<Integer> prevc = new ArrayList<Integer>();
                prevc.add(c2);
                map.put(c1,prevc);
            }
        }
        for(int i=0; i < numCourses; i++){
            if(!map.containsKey(i))
                order.add(i);
        }
        for(Integer course: map.keySet()){
            if(!visited[course]){
                boolean result = dfs(course,map,order,visited,take);
                if(result == false)
                    return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for(int i=0; i < order.size(); i++){
            result[i] = order.get(i);
        }
        return result;
            
    }
    
    private boolean dfs(int course, Map<Integer, List<Integer>> map, List<Integer> order,boolean[] visited,boolean[] take){
        if(!map.containsKey(course))
            return true;
        if(visited[course])
            return take[course];
        visited[course] = true;
        List<Integer> prevc = map.get(course);
        for(Integer c: prevc){
            boolean isTake = dfs(c,map,order,visited,take);
            if(isTake == false)
                return false;
        }
        take[course] = true;
        order.add(course);
        return true;
    }
}

//BFS
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] precNum = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> courseOrder = new ArrayList<Integer>();
        int[] result = new int[numCourses];
        for(int i=0; i < prerequisites.length; i++){
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];
            if(map.containsKey(c2)){
                List<Integer> courses = map.get(c2);
                courses.add(c1);
                map.put(c2,courses);
                precNum[c1]++;
            }
            else{
                List<Integer> courses = new ArrayList<Integer>();
                courses.add(c1);
                precNum[c1]++;
                map.put(c2,courses);
            }
        }
        for(int i=0; i < numCourses; i++){
            if(precNum[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            Integer taken = queue.poll();
            if(map.containsKey(taken)){
                 List<Integer> goingToTake = map.get(taken);
                for(Integer c: goingToTake){
                    precNum[c]--;
                    if(precNum[c] == 0)
                        queue.add(c);
                }
            }
            courseOrder.add(taken);
        }
        if(courseOrder.size() < numCourses)
            return new int[0];
        for(int i=0; i < numCourses; i++){
            result[i] = courseOrder.get(i);
        }
        return result;
    }
}
