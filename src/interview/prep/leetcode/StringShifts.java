package interview.prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * ou are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift). 
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

 

Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation: 
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
Example 2:

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:  
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 

Constraints:

1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100
 */

public class StringShifts {
    public String stringShift(String s, int[][] shift) {
    	int final_direction = 0; // -ve = left shift, +ve =right shift
    	int total_shifts = 0; //total amount of shifts to be performed on the string
    	
    	//Calculate all shifts necessary
    	for(int i=0; i< shift.length; i++) {
    		int flag = 0;
    		if(shift[i][0] == 0) {
    			final_direction--; // go left
    			flag = -1;
    		}
    		else {
    			final_direction++; //go right
    			flag = +1;
    		}
    		total_shifts = total_shifts+(flag*shift[i][1]);
    	}
    	
//    	total_shifts = total_shifts; //??Do we need Math.abs?
    	
    	
    	//List<Character> c = new ArrayList<>(Arrays(s.toCharArray()).boxed());
    	
    	List<Character> c = s.chars().mapToObj(e ->(char)e).collect(Collectors.toList());
    	
    	Collections.rotate(c,total_shifts);
    	
    	return c.stream().map(String::valueOf).collect(Collectors.joining());
    }
    
    public static void main(String args[]) {
//    	int[][] shift = {{0,1},{1,2}}; //[1,1],[1,1],[0,2],[1,3]
    	int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
    	System.out.println(new StringShifts().stringShift("abcdefg", shift));
    }
}
