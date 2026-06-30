
func valid(windowFreq, tgtFreq map[rune]int) bool{
    for c, n := range tgtFreq {
        if count:= windowFreq[c]; count < n {
            return false
        }
    }
    return true
}

func minWindow(s string, t string) string {
    if len(s)<len(t) {
        return ""
    }
    if s == t {
        return s
    }
    tRunes := []rune(t)
    sRunes := []rune(s)
    tgtFreq := make(map[rune]int)
    windowFreq := make(map[rune]int)
    for _,c := range tRunes {
        tgtFreq[c]++
    }
    l := 0;
    ans := ""
    for r:=0; r<len(sRunes); r++ { 
        windowFreq[sRunes[r]]++
        for valid(windowFreq,tgtFreq) {
            match := string(sRunes[l:r+1])
            if(ans=="" || len(match) < len(ans)){
                ans = match
            }
            windowFreq[sRunes[l]]--
            l++
        }
    }
    return ans

}
