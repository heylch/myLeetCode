//Greedy, Array
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length ==0)
            return 0;
        int result = 0;
        int[] numbers = new int[26];
        for(int i=0; i < tasks.length; i++)
            numbers[tasks[i]- 'A']++;
        Arrays.sort(numbers);
        int max = numbers[25];
        int maxNum = 0;
        int i = 25;
        while(numbers[i] == max){
            maxNum++;
            i--;
        }
        int blocksNum = max -1;
        int emptyIdleInBlock = n - (maxNum -1);
        int taskLeft = tasks.length - maxNum*max;
        int additonIdles = Math.max(0, blocksNum*emptyIdleInBlock - taskLeft);
        return tasks.length +  additonIdles;   
    }
}

//Priority Queue
class Solution {
    public int leastInterval(char[] tasks, int n){
            if(tasks.length == 0)
                return 0;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(int i=0; i < tasks.length; i++){
                if(map.containsKey(tasks[i]))
                    map.put(tasks[i], map.get(tasks[i]) +1);
                else
                    map.put(tasks[i], 1);
            }
            Queue<Integer> priorityQueue = new PriorityQueue<Integer>((a,b)-> (b-a));
            for(Character task: map.keySet())
                priorityQueue.add(map.get(task));
            int result = 0;
            while(!priorityQueue.isEmpty()){
                Queue<Integer> temp = new PriorityQueue<Integer>((a,b)-> (b-a));
                int k = n +1;
                while(!priorityQueue.isEmpty() && k >0){
                    int leftNum = priorityQueue.poll();
                    k--;
                    result++;
                    if(leftNum -1 >0){
                        temp.add(leftNum-1);
                    }
                }
                priorityQueue = temp;
                if(!priorityQueue.isEmpty())
                    result += k;
            }
            if(result >= tasks.length)
                return result;
            else
                return tasks.length;
        }
}