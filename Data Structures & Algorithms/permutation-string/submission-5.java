class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        Map<Character,Integer> tgtFreq = new HashMap<>();
        for(char c : s1.toCharArray()){
            tgtFreq.merge(c,1,Integer::sum);
        }
        int l=0;
        Map<Character,Integer> windowFreq = new HashMap<>();
        //init windowFreq
        for(char c: s2.substring(0,s1.length()).toCharArray()){
            windowFreq.merge(c,1,Integer::sum);
        }
        //maintain accuracy of windowFreq as l:r slides across string as a lens of fixed width
        for(int r=s1.length(); r<s2.length(); r++){
            if(windowFreq.equals(tgtFreq)) return true;
            windowFreq.merge(s2.charAt(r),1,Integer::sum);
            int updatedCount = windowFreq.computeIfPresent(s2.charAt(l),(k,v)->v-1);
            if(updatedCount==0){
                windowFreq.remove(s2.charAt(l));
            }
            l++;
        }
        return windowFreq.equals(tgtFreq);
    };
}
