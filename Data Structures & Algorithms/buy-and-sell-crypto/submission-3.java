class Solution {
    public int maxProfit(int[] prices) {
        int gain = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i =0; i<prices.length; i++){
            gain = Math.max(prices[i]-minPrice, gain);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return gain;
    }
}
