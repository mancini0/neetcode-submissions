class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxByComplement = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            int n = nums[i];
            if(idxByComplement.containsKey(target-n)){
                int j = idxByComplement.get(target-n);
                return (j>i?  new int[]{i,j} :  new int[] {j,i});
            }
            idxByComplement.put(n,i);
        }
        return new int[]{};
    }
}
