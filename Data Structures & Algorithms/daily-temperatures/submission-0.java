class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temps.length];
        Arrays.fill(res,0);
        for(int i=0;i<temps.length;i++){
            while(!stack.isEmpty() && temps[stack.peek()]<temps[i]){
                int idx = stack.pop();
                res[idx]=i-idx;
            }
            stack.push(i);
        }
        return res;
    }
    
}
