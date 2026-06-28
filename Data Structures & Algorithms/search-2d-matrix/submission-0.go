func searchMatrix(matrix [][]int, tgt int) bool {
	l := 0
	r := len(matrix)-1
	n := len(matrix[0])
	row := 0

	//find row
	for l<=r {
		mid := l + (r-l)/2;
		if tgt >= matrix[mid][0] && tgt<=matrix[mid][n-1] {
			row =mid
			break
		} else if tgt < matrix[mid][0] {
			r = mid-1
		} else {
			l=mid+1
		}
	}
	//binary search row
	l=0
	r=n-1
	for l<=r {
		mid := l + (r-l)/2
		if tgt == matrix[row][mid] {
			return true
		}
		if tgt > matrix[row][mid]{
			l=mid+1
			continue
		}
		r=mid-1
	}
	return false

}
