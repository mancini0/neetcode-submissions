class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> count = new HashMap<>();

        for(int i : arr1){
            count.compute(i, (k,v) ->{
                if(v==null) return 1;
                return v+1;
            });
        }
        Set<Integer> cache = new HashSet<>();
        for(int i : arr2){
            cache.add(i);
        }

        int[] suffix = Arrays.stream(arr1).filter(i->!cache.contains(i)).sorted().toArray();
        int[] ans = Arrays.copyOf(arr1,arr1.length);
        int idx = 0;
        for(int i=0; i<arr2.length; i++){
            for(int j = 0; j<count.getOrDefault(arr2[i],0); j++){
                ans[idx]=arr2[i];
                ++idx;
            }
        }
        System.arraycopy(suffix,0,ans,ans.length-suffix.length,suffix.length);
        return ans;
    }
}