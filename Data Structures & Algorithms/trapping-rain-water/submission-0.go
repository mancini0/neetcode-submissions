func trap(height []int) int {
	if len(height)<3 { 
		return 0
	}
	sum := 0
	leftMax := make([]int,len(height));
	rightMax := make([]int,len(height));
	leftMax[0] = height[0];
	rightMax[len(height)-1]=height[len(height)-1]
	for i:=1; i<len(height); i++ {
		leftMax[i] = max(leftMax[i-1],height[i])
	}
	
	for i:=len(height)-2; i>=0; i--{
		rightMax[i] = max(rightMax[i+1],height[i])
	}
	for i:=0; i<len(height); i++ {
		w := min(rightMax[i],leftMax[i]) - height[i]
		if(w>0){
			sum+=w
		}
	}
	return sum
}
