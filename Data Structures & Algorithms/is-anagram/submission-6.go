import "maps"
func populate(s string) map[rune] int {
    if len(s)==0{
        return nil
    }
    m := make(map[rune] int)
    for _,v := range s {
       m[v]++
    }
    return m
}

func isAnagram(s string, t string) bool {
    sCounts := populate(s);
    tCounts := populate(t);
    return maps.Equal(sCounts, tCounts)
    
}
