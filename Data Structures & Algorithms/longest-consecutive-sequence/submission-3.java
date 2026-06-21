class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new TreeSet<>();
        for(int i : nums){
            set.add(i);
        }

        nums = set.stream().mapToInt(Integer::intValue).toArray();
        int longestSequence = 1;
        int curSequence = 1;
        for(int i =0; i<nums.length-1; i++){
            if(nums[i+1]-nums[i] ==1){
                curSequence++;
                longestSequence = longestSequence > curSequence? longestSequence:curSequence;
            }
            else{
                curSequence = 1;
            }
        }
        return longestSequence;
    }
}
