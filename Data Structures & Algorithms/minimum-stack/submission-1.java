class MinStack {
    
    private Integer minimum = null;
    

    private record IntPair (int value, Integer minimum) {}
    private final Deque<IntPair> stack = new ArrayDeque<>();


    public MinStack() {
    }
    
    public void push(int val) {
        stack.push(new IntPair(val,minimum));
        if(minimum == null || minimum > val){
            minimum=val;
        }
    }
    
    public void pop() {
        IntPair cur = stack.pop(); 
        if (cur.value == minimum) {
            minimum = cur.minimum;
        }
    }
    
    public int top() {
        IntPair cur = stack.peek() ;
        return cur.value;
    }
    
    public int getMin() {
        return minimum;
    }
}
