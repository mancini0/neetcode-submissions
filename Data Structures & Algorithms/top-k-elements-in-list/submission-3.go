import "slices"
func topKFrequent(nums []int, k int) []int {
    countsByNum:=make(map[int]int)
    for _, v := range nums {
        countsByNum[v]++
    }
    numsByCount := make(map[int]map[int]struct{})
    for num, count := range countsByNum {
        if numsByCount[count] == nil {
            m := make(map[int]struct{});
            numsByCount[count] = m 
        }
       numsByCount[count][num] = struct{}{}
    }
    res := make([]int, len(numsByCount))
    var ans []int
    for count, _ := range numsByCount {
        res = append(res, count)
    }
    slices.Sort(res);
    for k>0 {
        count := res[len(res)-1]
        for n, _ := range numsByCount[count] {
            ans = append(ans, n)
            k--
            if k<=0 {
                break
            }
        }
        res = res[:len(res)-1]
    }
    return ans

}
