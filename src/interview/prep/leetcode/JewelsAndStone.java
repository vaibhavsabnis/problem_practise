package interview.prep.leetcode;

import java.util.*;

/*
 * Jewels and Stones
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */

public class JewelsAndStone {
	
	public int numJewelsInStones(String J, String S) {
		int howManyJewels=0;
		
		if(J == null || J.length()==0 || S ==null || S.length() ==0)
			return 0;
		
		Set<Character> jewelSet = new HashSet<>();
        for(char c: J.toCharArray()){
        	jewelSet.add(c);
        }
        
        for(int i=0; i<S.length();i++) {
        	Character s = S.charAt(i);
        	if (jewelSet.contains(s))
        		howManyJewels++;
        }
        
        return howManyJewels;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
