package interview.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class KthFrequentElement {

    @SuppressWarnings("unchecked")
    public List<Integer> topKFrequent(int[] nums, int k) {
        
    	
    	List<Integer>[] buckets = (List<Integer>[]) new ArrayList[nums.length+1];
    	
    	HashMap<Integer,Integer> hm= new HashMap<>();
    	
    	for(int i=0;i<nums.length; i++) {
    		if(hm.get(i)!=null) {
    			hm.put(i,hm.get(i)+1);
    		}else {
    			hm.put(i,1);
    		}
    		buckets[i+1] = null;
        }

    	System.out.println("Hashmap:" + hm);
    	
    	Set<Integer> keys = hm.keySet();
    	
    	for(Integer key:keys) {
    		int val = hm.get(key);
    		
    		if(buckets[val]!=null) {
    			List<Integer> freqList = buckets[val];
    			freqList.add(key);
    		}else {
    			List<Integer> freqList = new ArrayList<>();
    			freqList.add(key);
    			buckets[val] = freqList;
    		}
    	}
    	
		int index =1;
    	for(List<Integer> i: buckets) {
    		System.out.println("Freq:"+index+" Bucket Value: " +i);
    		index++;
    	}
    	
    	List<Integer> lstToReturn= new ArrayList<>();
    	
    	for(int i = nums.length; i>=0; i-- ) {
    		System.out.println("Working on index:" + i +" Value at index:" + buckets[i]); 
    		if(buckets[i]==null)
    			continue;
    		else {
    			lstToReturn.addAll(buckets[i]);    			
    		}
    	}
    	
    	return lstToReturn.subList(0, k);
    }
    
    public static void main(String a[]) {
    	int[] nums = {1,1,1,2,2,3,3,3,4,12,12,12,12,5,6,7,78,9,10};
    	List<Integer> l = new KthFrequentElement().topKFrequent(nums, 5);
    	System.out.println(l);
    }
}
