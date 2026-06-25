class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> closersByOpeners = Map.of('(',')','{','}','[',']');
        
        Deque<Character> stack = new ArrayDeque<>();
    
        for(Character c : s.toCharArray()){
            if(closersByOpeners.containsKey(c)){
                stack.push(closersByOpeners.get(c));
            }
            else if(closersByOpeners.values().contains(c)) {
                if(stack.isEmpty() || !stack.pop().equals(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
