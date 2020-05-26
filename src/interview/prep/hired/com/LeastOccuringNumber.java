package interview.prep.hired.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/*
 * Return the least occuring number. If there are multiple, return all those as an array in sorted order. If there are none return a blank array.  
 */
public class LeastOccuringNumber {

	public static long[] returnLeastOccuringNumbers(long[] numbers) {     
        // Type your solution here
      
      if(numbers.length ==0)
        return new long[] {};
      if (numbers.length ==1)
        return numbers; 
      
      Map<Long,Integer> numFreqMap = new HashMap<>();
      for (int i=0; i<numbers.length; i++){
        numFreqMap.put(numbers[i],numFreqMap.getOrDefault(numbers[i],0)+1); 
      }
      
      int minOccur = Integer.MAX_VALUE;
      Set<Long> minNumList = new HashSet<>(); 

      Set<Long> keys = numFreqMap.keySet(); 
      
      Iterator<Long> iter = keys.iterator(); 
      while(iter.hasNext()){
        Long num = iter.next(); 
        Integer count = numFreqMap.get(num); 
        if(count<minOccur) {
          //cleanup the existing set as a new min is found
          minNumList.clear(); 
          minOccur = count; 
          minNumList.add(num);
        }else if(count == minOccur) {
           minNumList.add(num);
        }else{
          continue; 
        }        
      }
      
      int size = minNumList.size(); 
      if(size==0)
        return new long[] {};
      
      long[] res = new long[size];
      int i = 0; 
      for(Long x:minNumList)
        res[i++] = x; 
      
      Arrays.sort(res); 
      return res; 
    }
	
	public static void main(String[] args) {
		
	}

}
