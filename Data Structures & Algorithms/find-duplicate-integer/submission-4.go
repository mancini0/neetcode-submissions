// --H-units---|----X---|    
//                  |loop    |    
//                  |distance|
//                  |__C_____|
//
// v1 = H/t1 (tortoise speed - 1 unit of distance per unit of time, enters loop at H ticks of time)
// v2 = 2v1  (hare speed - 2 units of distance per unit of time)
// at time t2 > H, the hare will inevitably collide with tortoise since both are on the same track and the hare's 
// relative speed closes the gap by exactly 1 unit per tick. Call their collision point in the loop D at time t2.
// The tortoise has traveled H+D at this point. The hare has traveled 2(H+D), or H+kC+D (H down the lane, 
// plus k laps, plus some distance D to the collision point).
// so: 2H + 2D = H + kC + D
//     H = kC - D
// So resetting one party back to 0, setting both speeds to 1 unit per tick, and elapsing H ticks of the clock 
// means whoever moved back to the starting line ended up at H. Whoever stayed at D also moved H steps (or kC-D steps), 
// which is mechanically identical to walking back D steps to the entrance and running k full laps.
// Therefore, both parties end up simultaneously at the loop entrance.
func findDuplicate(nums []int) int {
	slow:=0
	fast:=0
	for {
		slow =nums[slow]
		fast = nums[fast]
		fast = nums[fast]
		if slow == fast {
			break
		}
	}
	fast = 0

	for {
		slow=nums[slow]
		fast=nums[fast]
		if slow == fast {
			return slow
		}
	}
	return -1

}
