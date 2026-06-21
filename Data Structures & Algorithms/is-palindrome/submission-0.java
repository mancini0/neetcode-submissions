class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
        System.out.println(s);
        char[] chars  = s.toCharArray();
        int j = chars.length -1;
        for(int i = 0; i<chars.length; i++){
            if (chars[i]==chars[j--]) continue;
            return false;
        }
        return true;
    }
}
