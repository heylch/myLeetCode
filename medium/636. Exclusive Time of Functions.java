class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        int preTime = 0;
        for(int i=0; i < logs.size(); i++){
            String log = logs.get(i);
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[2]);
            if(!stack.isEmpty()){
                if(parts[1].equals("start"))
                    result[stack.peek()] += time - preTime;
                else
                    result[stack.peek()] += time - preTime+1;
            }
            preTime = time;
            if(parts[1].equals("start")){
                stack.push(id);
            }
            else{
                stack.pop();
                preTime++;
            }
        }
        return result;
    }
}