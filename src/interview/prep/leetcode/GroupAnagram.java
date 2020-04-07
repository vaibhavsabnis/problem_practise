package interview.prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * Leetcode: April 6th 2020
 * 
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        
    	Map<String, List<String>> grpMap = new HashMap<>();
    			
    	for(int i=0; i<strs.length;i++) {
    		
    		char[] c = strs[i].toCharArray();
    		Arrays.parallelSort(c);
    		String strc = String.valueOf(c);
    		
    		if(grpMap.get(strc) == null) {
    			List<String> l = new ArrayList<>();
    			l.add(strs[i]);
    			grpMap.put(strc,l);
    		}
    		else {
    			List<String> l = grpMap.get(strc);
    			l.add(strs[i]);
    			
    			grpMap.put(strc,l);
    		}
    		
    	}
    	
//    	List<List<String>> toRet = new ArrayList<>(grpMap.values());
    	
    	return new ArrayList<>(grpMap.values());
        
    }
    
    public static void main(String a[]) {
    	String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
    	System.out.println(new GroupAnagram().groupAnagrams(s));
    }

}
