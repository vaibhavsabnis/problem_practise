package interview.prep.leetcode.oct20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Buddy Strings

Solution
Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
Example 2:

Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
Example 3:

Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Constraints:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist of lowercase letters.
 
 */
public class BuddyStrings {
	   public boolean buddyStrings(String A, String B) {
		   if(A.length() != B.length() || A.length() ==1)
			   return false; 
		   
		   if(A.equals(B)) {
			   Set<Character> s = new HashSet<>(); 
			   for(char c: A.toCharArray()) {
				   if(s.contains(c))
					   return true; 
				   s.add(c);
			   }
			   return false; 
		   }
		   
		   List<Integer> mismatch = new ArrayList<>();
		   for(int i=0; i<A.length(); i++) {
			   if(A.charAt(i) != B.charAt(i)) {
				   mismatch.add(i);				   
			   }
			   if(mismatch.size() >2) return false; 
		   }
		   if(mismatch.size() !=2)
			   return false; 
		   
		   return A.charAt(mismatch.get(0)) == B.charAt(mismatch.get(1)) && A.charAt(mismatch.get(1)) == B.charAt(mismatch.get(0));   
	   }
}
