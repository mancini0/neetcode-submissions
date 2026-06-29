func search(nums []int, target int) int {
	l := 0
	r := len(nums)-1
	for l<=r {
		mid := l + (r-l)/2
		if nums[mid] == target {
			return mid
		}
		if nums[mid] > nums[r] {
			//right side is unsorted, lets check if target lives in left side:
			if target>=nums[l] && target<nums[mid]{
				r = mid-1
				continue
			}
			l=mid+1; //the target is on the right, unsorted side.
		} else {
			//left side is unsorted, lets check if target lives on right side
			if target>nums[mid] && target<=nums[r] {
				l=mid+1
				continue
			}
			r=mid-1 // the target is on the left, unsorted side
		}
	}
	return -1;
}
