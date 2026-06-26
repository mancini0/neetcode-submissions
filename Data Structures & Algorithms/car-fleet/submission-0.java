class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> idxByPosition = new TreeMap<>(Comparator.reverseOrder());
        Map<Integer,Double> etaByIdx = new HashMap<>();
        for(int i =0; i<speed.length; i++){
            double eta = 1.0*(target-position[i])/speed[i];
            idxByPosition.put(position[i],i);
            etaByIdx.put(i,eta);
        }
        Deque<Double> stack = new ArrayDeque<>();
        for(int idx : idxByPosition.values()){
            if(stack.isEmpty() || etaByIdx.get(idx)>stack.peek()){
                stack.push(etaByIdx.get(idx));
            }
        }
        return stack.size();
        
    }
}
