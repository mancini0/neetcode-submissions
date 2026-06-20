class Solution {
    //In practice I would use Jackson to serialize as json, or base64 encode the byte[]
    //produced by serializing via java.io.ObjectOutputStream() - but neetcode did not allow
    //importing packagae java.io;
    public String encode(List<String> strs) {
        //next three digits represent length 0-left padded
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<strs.size(); i++ ){
            var len = String.format("%03d",strs.get(i).length());
            var str = strs.get(i);
            sb.append(len).append(str);
        } 
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i =0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
            //Integer idx = Integer.parseInt(str.substring(i,i+3));
            Integer len = Integer.parseInt(str.substring(i,i+3));
            String data = str.substring(i+3,i+3+len);
            res.add(data);
            i=i+3+len;
        }
        return res;

    }
}
