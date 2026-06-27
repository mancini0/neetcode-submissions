class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i=0;i<=heights.length; i++){
            int h = i==heights.length? 0 : heights[i];
            while(!stack.isEmpty()&& h<heights[stack.peek()]){
                int r= stack.pop();
                int l = stack.isEmpty()?-1:stack.peek();
                maxArea = Math.max(heights[r]*(i-l-1),maxArea);
               
            }
            stack.push(i);
        }
        return maxArea;
    }
}
