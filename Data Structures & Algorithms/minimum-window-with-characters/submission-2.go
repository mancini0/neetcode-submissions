func valid(windowFreq, tFreq map[rune]int) bool {
	for c, freq:= range tFreq {
		if wf, exists := windowFreq[c]; exists {
			if wf < freq {
				return false
			}
		} else {
			return false
		}
	}
	return true
}
func minWindow(s string, t string) string {
    sr := []rune(s)
	tr := []rune(t)
	if len(sr) < len(tr) {
		return ""
	}
	tFreq := map[rune]int{}
	windowFreq := map[rune]int{}
	for _,c := range tr{
		tFreq[c]++
	}
	l:=0
	r:=len(tr)
	for _, c:= range sr[l:r] {
		windowFreq[c]++
	}
	res := ""

	for r<=len(sr){
		for valid(windowFreq,tFreq){
			substr := string(sr[l:r])
			if len(res) == 0 || len(substr) < len(res) {
				res=substr
			}
			windowFreq[sr[l]]--
			l++		
		}
		if r==len(sr){
			break
		}
		windowFreq[sr[r]]++
		r++;
	}
	return res
}
