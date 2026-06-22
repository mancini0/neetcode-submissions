

func isPalindrome(s string) bool {
    re := regexp.MustCompile("[^a-zA-Z0-9]+")
    clean := []rune(strings.ToLower(re.ReplaceAllString(s,"")))
    idx := len(clean)-1
    for i:=0; i<idx; i++ {
        if clean[i]!= clean[idx] {
            return false
        }
        idx--
    }
    return true
}
