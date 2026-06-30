class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> windowFreq = new HashMap<>();
        int l = 0;
        int mostRepeatedFreq = 0;
        int maxLen = -1;
        for(int r=0;r<s.length();r++){
            mostRepeatedFreq = Math.max(mostRepeatedFreq,windowFreq.merge(s.charAt(r),1,Integer::sum));
            while(r-l+1-mostRepeatedFreq > k){
                windowFreq.computeIfPresent(s.charAt(l),(key,v)->--v);
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
