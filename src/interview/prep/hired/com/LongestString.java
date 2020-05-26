package interview.prep.hired.com;
/*
 * Given a string s find the longest substring with no repeating characters.
*/

import java.util.*; 

public class LongestString {
	
	public static long longestStringWithinString(String s) {
        // Type your solution here
      if(s == null)
        return 0;
      if(s.length() == 1)
        return 1L;
      
      int len = s.length();
      long result = 0;
      int st = 0;
      
      int[] idxTrack = new int[256];//Assume UTF-8 char set with max of 0-255 chars
      java.util.Arrays.fill(idxTrack,-1);
      
      for (int en=0; en<len; en++){
      	st = Math.max(st,idxTrack[s.charAt(en)]+1); 
        
        result = Math.max(result,en-st+1);
        idxTrack[s.charAt(en)] = en;
      }
      return result; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
