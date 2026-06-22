func lengthOfLongestSubstring(s string) int {
	set := make(map[rune]struct{})
	runes := []rune(s);
	l := 0
	maxLen := 0
	for _,c := range s {
		_, exists := set[c]
		for exists {
			delete(set,runes[l])
			l++
			_, exists = set[c]
		}
		set[c]=struct{}{}
		maxLen = max(maxLen, len(set))
	}
	return maxLen
}
