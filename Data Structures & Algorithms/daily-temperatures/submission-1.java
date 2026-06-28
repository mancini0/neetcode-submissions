class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0; i<temps.length; i++){
            while(!stack.isEmpty() && temps[i]>temps[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i-idx;
            }
            stack.push(i);
        }
        return res;
    }
}
