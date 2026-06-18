class Solution {
    protected Map<Character,Integer> populate (String s){
        if(s==null) return Map.of();
        Map<Character,Integer> m = new HashMap<>();
        for(Character c: s.toCharArray()){
            m.compute(c, (k,v)->{
                if(v==null) return 1;
                return v+1;
            });
        }
        return m;
    }
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charCountsS = populate(s);
        Map<Character, Integer> charCountsT = populate(t);
        return charCountsS.equals(charCountsT);
    }
        
}
