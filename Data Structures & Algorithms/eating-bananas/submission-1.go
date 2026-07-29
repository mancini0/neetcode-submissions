import "slices"

func possible(piles []int, h int, r int) bool{
    time := 0
    for _, v := range piles {
        time = v/r + time
        if v % r !=0 {
            time++
        }
    }
    return time <= h
}

func minEatingSpeed(piles []int, h int) int {
    l :=1
    r := slices.Max(piles)
    ans := 0
    for l<=r {
        mid := l + (r-l)/2
        if possible(piles,h,mid){
            ans = mid
            r = mid-1
        }else{
            l=mid+1
        }
    }
    return ans

}
