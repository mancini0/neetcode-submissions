class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s : tokens){
            switch(s){
                case "+" -> {
                    var r = stack.pop();
                    var l = stack.pop();
                    stack.push(l+r);
                }
                case "-" -> {
                    var r = stack.pop();
                    var l = stack.pop();
                    stack.push(l-r);
                }
                case "*" -> {
                    var r = stack.pop();
                    var l = stack.pop();
                    stack.push(l*r);
                }
                case "/" -> {
                    var r = stack.pop();
                    var l = stack.pop();
                    stack.push(l/r);
                }
                default -> {
                    stack.push(Integer.parseInt(s));
                }
            }
        }
        return stack.pop();
        
    }
}
