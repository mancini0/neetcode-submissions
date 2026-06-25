class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> openToClose = Map.of('(',')','[',']','{','}');
        Set<Character> closers = new HashSet<>(openToClose.values());
        Deque<Character> stack = new ArrayDeque<>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(openToClose.containsKey(c)){
                stack.push(openToClose.get(c));
            }else if(closers.contains(c) && stack.isEmpty() || stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();


    }
}
