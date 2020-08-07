package interview.prep.leetcode.aug20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {
	public List<Integer> findDuplicates(int[] nums) {

        Map<Integer,Integer>  map = new HashMap<>(); 
        List<Integer> ans = new ArrayList<>(); 
        for(int x: nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        // Iterator<Integer> iter = map.keyset().iterator(); 
        
       for(Integer key: map.keySet()){
            // Integer key = iter.next();
            if(map.get(key) > 1)
                ans.add(key);
        }
        
        return ans; 
    }
}
