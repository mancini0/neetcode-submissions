import (
    "slices"
)
func groupAnagrams(strs []string) [][]string {
    m := make(map[string][]string )
    for _,str := range strs {
        r := []rune(str);
        slices.Sort(r)
        key := string(r)
        if v,ok := m[key]; ok {
            m[key] = append(v, str)
        } else {
            l := make([]string,1,3)
            l[0] = str
            m[key] = l
        }
    }
    r := make([][]string,0,len(m))
    for _, v := range m {
        r = append(r, v)
    }
    return r
}