class TimeMap {
    private final Map<String,TreeMap<Integer,String>> map = new HashMap<>();

    public TimeMap() {    
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k->new TreeMap<>()).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        return Optional.ofNullable(map.get(key))
        .flatMap(vals->Optional.ofNullable(vals.floorEntry(timestamp)))
        .map(e->e.getValue())
        .orElse("");
    }
}
