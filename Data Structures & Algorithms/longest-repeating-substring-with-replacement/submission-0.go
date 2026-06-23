func characterReplacement(s string, k int) int {
	runes := []rune(s)
	cnts := make(map[rune]int)
	freq:= 0
	longest := 0
	l := 0
	for r,v := range runes {
		cnts[v]++
		if cnts[v] > freq {
			freq = cnts[v]
		}
		for r-l+1-freq > k{
			cnts[runes[l]]--
			l++
		}
		longest = max(longest, r-l+1)
	}
	return longest

}
