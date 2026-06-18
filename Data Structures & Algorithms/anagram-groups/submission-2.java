class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagrams = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            anagrams.computeIfAbsent(key, k->new ArrayList<>()).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> col : anagrams.values()){
            result.add(col);
        }
        return result;

    }
}
