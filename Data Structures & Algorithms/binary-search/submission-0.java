class Solution {
    public int search(int[] nums, int target) {
        int res =Arrays.binarySearch(Arrays.stream(nums).sorted().toArray(), target);
        return res>-1? res: -1;
    }
}
