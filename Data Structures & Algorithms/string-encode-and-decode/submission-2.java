class Solution {

    public String encode(List<String> strs) {
        //first three digits represent index 0-left padded
        //next three digits represent length 0-left padded
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<strs.size(); i++ ){
            var idx = String.format("%03d", i);
            var len = String.format("%03d",strs.get(i).length());
            var str = strs.get(i);
            sb.append(idx).append(len).append(str);
        } 
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i =0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
            Integer idx = Integer.parseInt(str.substring(i,i+3));
            Integer len = Integer.parseInt(str.substring(i+3,i+6));
            String data = str.substring(i+6,i+6+len);
            res.add(data);
            i=i+6+len;
        }
        return res;

    }
}
