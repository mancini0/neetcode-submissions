class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones ){
            pq.offer(i);
        }
        while(pq.size()>0){
            var a = pq.poll();
            var b = pq.peek();
            if(b==null) return a;
            b = pq.poll();
            if(a-b > 0) pq.offer(a-b);
        }
        if(pq.size()>0) return pq.poll();
        return 0;
    }
}
