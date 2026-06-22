func maxArea(heights []int) int {
	l := 0
	r := len(heights)-1
	area := 0
	for l<r {

		if heights[l] == min(heights[l], heights[r]) {
			area = max(area, heights[l]*(r-l))
			l++
		} else {
			area = max(area, heights[r]*(r-l))
			r--
		}
	}
	return area;
}
