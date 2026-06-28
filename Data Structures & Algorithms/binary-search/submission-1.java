class Solution {
    public int search(int[] nums, int target) {
        int res =Arrays.binarySearch(nums, target);
        return res>-1? res: -1;
    }
}
