import (
	"maps"
)

func valid(windowFreq, targetFreq map[rune]int) bool {
	for k,v := range targetFreq {
		if freq, exists := windowFreq[k]; exists {
			if freq < v{
				return false
			}
		} else {
			return false
		}
	}
	return true
}

func minWindow(s string, t string) string {
	tFreq := make(map[rune]int)
	tRunes := []rune(t)
	sRunes := []rune(s)
	windowFreq := make(map[rune]int)
	for _,c := range tRunes {
		tFreq[c]++
	}

	if len(tRunes) > len(sRunes) {
		return ""
	}
	if len(tRunes) == len(sRunes) {
		for _, c:= range sRunes {
			windowFreq[c]++
		}
		if maps.Equal(windowFreq,tFreq) {
			return s
		}
		return ""
	}
	l:=0
	r:=len(tRunes)
	substr := sRunes[l:r]

	for _, c:= range substr {
			windowFreq[c]++
	}
	minString := ""
	for r<=len(sRunes){
		for valid(windowFreq,tFreq){
			reduced := string(sRunes[l:r])
			if len(reduced)<len(minString) || minString == ""{
				minString = reduced
			}
			windowFreq[sRunes[l]]--
			l++
		}
		if r==len(sRunes){
			break
		}
		windowFreq[sRunes[r]]++
		r++
		
	}
	return minString
}

