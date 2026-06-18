func hasDuplicate(nums []int) bool {
    m := make(map[int]struct{})
    for _, v := range nums {
        _,ok := m[v]; if ok {
            return true
        }
        m[v] = struct{}{}
    }
    return false
}
