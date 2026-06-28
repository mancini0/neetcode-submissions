import "slices"
func possible(r int, piles []int, h int) bool {
	hours := 0
	for _, v  := range piles {
		time := v/r
		if v%r != 0 {
			time++
		}
		hours += time
	}
	return hours <= h
}

func minEatingSpeed(piles []int, h int) int {
  l := 1
  r := slices.Max(piles)
  ans := r
  for l<=r {
	mid := l + (r-l)/2
	if possible(mid,piles,h){
		ans = mid
		r = mid-1
		continue
	}
	l=mid+1 
  }
  return ans
}
