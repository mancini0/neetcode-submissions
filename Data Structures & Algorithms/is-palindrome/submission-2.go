
func isPalindrome(s string) bool {
	re := regexp.MustCompile("[^a-zA-Z0-9]+")
	r := []rune(strings.ToLower(re.ReplaceAllString(s,"")))
	
	for i, j :=0, len(r)-1; i<j; {
		if r[i]!=r[j] {
			return false
		}
		i++
		j--
	}
	return true
}
