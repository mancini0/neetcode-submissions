class KthLargest {

    private final TreeMap<Integer, Integer> countsByVal;
    private final int k;
    public KthLargest(int k, int[] nums) {
        this.countsByVal = new TreeMap<>(Comparator.reverseOrder());
        this.k=k;
        for(int i : nums){
            this.countsByVal.compute(i, (ke,v) -> v==null?1:v+1);
        }
    }
    
    public int add(int val) {
        this.countsByVal.compute(val, (k,v) -> v==null?1:v+1);
        var i = k;
        for(Map.Entry<Integer,Integer> e : countsByVal.entrySet()){
            i-=e.getValue();
            if(i<=0){
                return e.getKey();
            }
        }
        return -1;
    }
}
