class LRUCache {
    private final LinkedHashMap<Integer,Integer> cache;
    private final int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache = new LinkedHashMap<Integer,Integer>(capacity,.75f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        cache.put(key,value);
    }
}
