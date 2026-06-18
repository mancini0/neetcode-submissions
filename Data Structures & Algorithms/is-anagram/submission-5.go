import "maps"
func populate(s string) map[rune] int {
    if len(s)==0{
        return nil
    }
    m := make(map[rune] int)
    for _,v := range []rune(s) {
        if cnt,ok := m[v]; ok{
            m[v] = cnt +1
        } else {
            m[v] = 1;
        }
    }
    return m
}

func isAnagram(s string, t string) bool {
    sCounts := populate(s);
    tCounts := populate(t);
    return maps.Equal(sCounts, tCounts)
    
}
