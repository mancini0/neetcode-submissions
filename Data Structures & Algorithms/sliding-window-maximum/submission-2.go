import (
	"slices"
)
func maxSlidingWindow(nums []int, k int) []int {
	window:= make([]int,k,k)
	l:=0
	copy(window[:],nums[l:k])
	res:=make([]int,0,(len(nums)/k)+len(nums)%k)
	if k == len(nums){
		res = append(res, slices.Max(nums))
		return res
	}
	for r:=k; r<=len(nums);r++{
		res = append(res, slices.Max(window))
		l++
		if r==len(nums){
			break
		}
		copy(window,nums[l:l+k])
	}
	return res
}
