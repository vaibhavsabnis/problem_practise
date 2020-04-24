package interview.prep.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );//capacity

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


Input:
["LRUCache","put","put","get","put","put","get"]
[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
Output:
[null,null,null,1,null,null,-1]
Expected:
[null,null,null,2,null,null,-1]

 */

public class LRUCache {

	Map<Integer,Integer> cache;
	final int maxSize;
	
	public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        maxSize = capacity;
    }
    
    public int get(int key) {
    	Integer val= cache.get(key);
    	
    	if (val == null)
        	return -1;
    	
        cache.remove(key);
        cache.put(key, val);
        return val;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
        	this.get(key);
        	cache.put(key,value);
        }
        else {
        	if(cache.size()+1>maxSize) {//evict the last one
        		Entry<Integer, Integer> leastUsed = cache.entrySet().iterator().next();
				cache.remove(leastUsed.getKey());
        	}
        	cache.put(key,value);        	
        }        	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
