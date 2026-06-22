func maxProfit(prices []int) int {
		n:=len(prices)
		if n <2 {
			return 0
		}

		gain := 0
		minLeft := make([]int, n)
		minLeft[0] = prices[0]
		for i:=1; i<n; i++ {
			minLeft[i] = min(minLeft[i-1],prices[i])
			gain = max(gain,prices[i] - minLeft[i])
		}
		return gain

}
