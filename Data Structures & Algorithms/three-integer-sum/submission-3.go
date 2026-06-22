import "slices"
func threeSum(nums []int) [][]int {
	res := make([][]int,0)
	slices.Sort(nums)
	for i:=0; i<len(nums); i++ {
		if i>0 && nums[i]==nums[i-1] {
			continue
		}
		if nums[i]>0 {
			break
		}
		fixed:=nums[i]
		j := i+1
		k := len(nums)-1
		for j<k {
			if nums[j] + nums[k] + fixed > 0 {
				k--
			} else if nums[j]+nums[k] + fixed < 0 {
				j++
			} else {
				res = append(res, []int{nums[i],nums[j],nums[k]})
				//fast fwd through adjacent dupes
				for j<k && nums[j] == nums[j+1] {
					j++
				}
				//fast fwd through adjacent dupes
				for j<k && nums[k] == nums[k-1] {
					k--
				}
				j++
				k--
			}
		}
	}
	return res;

}
