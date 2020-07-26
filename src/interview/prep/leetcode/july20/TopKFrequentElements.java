package interview.prep.leetcode.july20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>(); 
        List<Integer> cntLst = new ArrayList<>(); 
        
        for(int i: nums){
            int freq = freqMap.getOrDefault(i,0)+1; 
            freqMap.put(i,freq);
        }
        
        cntLst.addAll(freqMap.keySet());
        Collections.sort(cntLst, (o1, o2) -> {        	
                int o1Freq = freqMap.get(o1);
        		int o2Freq = freqMap.get(o2);
        		if(o1Freq <o2Freq)
        			return 1;
        		else if(o1Freq > o2Freq)
        			return -1;
        		else
        			return o2.compareTo(o1);        		
        	});
        
	    return cntLst.subList(0, k).stream().mapToInt(x->x).toArray(); 
    }
}
