func lengthOfLongestSubstring(s string) int {
	runes := []rune(s)
	n := len(runes)
	l:=0;
	maxLength := 0
	m := make(map[rune]struct{}, n)
	for _, c := range runes {
		_, exists := m[c];
		for exists {
			delete(m, runes[l])
			l++
			_, exists = m[c]
		}
		m[c] = struct{}{}
		maxLength = max(maxLength, len(m))
	}
	return maxLength
}
