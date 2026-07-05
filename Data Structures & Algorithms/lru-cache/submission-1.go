//import "container/list"

type LRUCache struct {
 m map[int]*list.Element 
 capacity int
 l *list.List
}

type Pair struct {
	 key int
	 value int
}

func Constructor(capacity int) LRUCache {
	m := make(map[int]*list.Element)
	l := list.New()
	return LRUCache {m,capacity,l}    
}

func (this *LRUCache) Get(key int) int {
    v, ok := this.m[key]
	if !ok {
		return -1
	}else {
		this.l.MoveToBack(v)
		return v.Value.(Pair).value
	}
}

func (this *LRUCache) Put(key int, value int) {

	v, ok := this.m[key]
	if !ok {
		if len(this.m) >= this.capacity {
			if f:= this.l.Front(); f!= nil {
				delete(this.m, f.Value.(Pair).key)
				this.l.Remove(f)
			}
		}
		el := this.l.PushBack(Pair{key,value})
		this.m[key]=el
	} else {
		v.Value = Pair{key: key, value: value}
		this.l.MoveToBack(v)
	}
}
	
