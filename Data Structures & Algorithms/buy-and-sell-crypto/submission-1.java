class Solution {
    public int maxProfit(int[] prices) {
        int gain = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            gain = Math.max(gain, prices[i]-min);
        }
        return gain;
    }

}
