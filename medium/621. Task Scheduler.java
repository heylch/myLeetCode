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