class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()) return 0;
        if(s.length()<2) return s.length();
        Map<Character,Integer> windowFreq = new HashMap<>();
        int l=0;
        int ans = -1;
        for(int r =0; r<s.length(); r++){
            char c = s.charAt(r);
            if(windowFreq.merge(c,1,Integer::sum)>1){
                while(windowFreq.get(c)>1){
                    windowFreq.computeIfPresent(s.charAt(l++),(k,v)->v-1);
                }
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
