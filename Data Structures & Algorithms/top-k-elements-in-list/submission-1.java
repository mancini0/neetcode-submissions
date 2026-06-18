class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countsByNum = new HashMap<>();
        for(int n : nums){
            countsByNum.compute(n, (key,val) ->{
                if(val==null)return 0;
                return val+1;
            });
        }

        TreeMap<Integer,Set<Integer>> numsByCount = new TreeMap<>(Comparator.reverseOrder());
        for(Map.Entry<Integer,Integer> e : countsByNum.entrySet()){
            numsByCount.computeIfAbsent(e.getValue(), key->new HashSet<>()).add(e.getKey());
        }
        int[] ret = new int[k];
        int i = 0;
        for(Map.Entry<Integer,Set<Integer>> e : numsByCount.entrySet()){
            for(int n : e.getValue()){
                ret[i++] = n;
                if(i==k) return ret;
            }
        }
        return ret;
    }
}
