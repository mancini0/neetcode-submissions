class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length <=1) return false;
        Set<Integer> filtered = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length > filtered.size();
    }
}