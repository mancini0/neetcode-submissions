func isValid(s string) bool {
    stack := make([]rune,0,len(s));
    
    pairs := map[rune]rune {
        '{':'}',
        '[':']',
        '(':')',
    }

    for _, c:= range []rune(s) {
        if val, ok := pairs[c]; ok {
            stack = append(stack, val)
        }else if len(stack)==0 || stack[len(stack)-1] != c{
            return false
        }else {
            stack = stack[:len(stack)-1]
        }
    }
    return len(stack)==0
}
