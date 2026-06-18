import "slices"
func twoSum(nums []int, target int) []int {
    m:= make(map[int]int,0)
    for i, v := range nums {
        if j, ok := m[target-v]; ok {
            x := []int{i,j}
            slices.Sort(x)
            return x
        }
        m[v] = i
    }
    return nil
}
