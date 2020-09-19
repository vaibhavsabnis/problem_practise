/*
 * Sequential Digits

Solution
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9
 */
package interview.prep.leetcode.sep20;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
	public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>(); 
        
        String lowStr = low+""; 
        int lowStartDigit = Character.getNumericValue(lowStr.charAt(0));
        int lowNumSize = lowStr.length(); 
        
        String highStr = high+""; 
        // int highStartDigit = Character.getNumericValue(highStr.charAt(0));
        int highNumSize = highStr.length(); 
        
        while(lowNumSize <= highNumSize){
            while(lowStartDigit <10)
            {
                StringBuilder newNum = new StringBuilder();         
                generateNextNum(lowStartDigit++,newNum,lowNumSize); 
                if(newNum.length()!=lowNumSize)
                	continue; 
                int num = Integer.parseInt(newNum.toString()); 
                if(num > high)
                    break; 
                if(num >=low && num<=high)
                    ans.add(num); 
            }
            
            lowStartDigit=1; 
            lowNumSize++; 
        }
            
        return ans;
    }
    private void generateNextNum(int currDigit,StringBuilder sb,int numSize){
        if(sb.length() >= numSize || currDigit == 10)
            return; 
        sb.append(currDigit++); 
        generateNextNum(currDigit,sb,numSize); 
    }
	public static void main(String args[]) {
		SequentialDigits sd = new SequentialDigits(); 
		sd.sequentialDigits(100, 13000); 
	}
}
