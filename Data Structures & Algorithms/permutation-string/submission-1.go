import "maps"
func checkInclusion(s1 string, s2 string) bool {
    if len(s1) > len(s2){
        return false
    }
    if s1 == s2 {
        return true;
    }
    s1Runes := []rune(s1)
    s2Runes := []rune(s2)
    s1Freq := make(map[rune]int)
    windowFreq := make(map[rune]int)
    for _, c := range s1Runes {
        s1Freq[c]++
    }
    l:=0
    for r, c := range s2Runes {
        windowFreq[c]++
        if r-l+1 == len(s1Runes){    
            if maps.Equal(s1Freq, windowFreq) {
                return true
            }
            windowFreq[s2Runes[l]]--
            if windowFreq[s2Runes[l]] == 0 {
                delete(windowFreq, s2Runes[l])
            }
            l++
        }
    }
    return false;
}
