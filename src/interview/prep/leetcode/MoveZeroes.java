package interview.prep.leetcode;

import java.util.Arrays;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
//      int countZero = 0;
      for(int i = 0; i<nums.length; i++){
          if(nums[i]!=0){
              continue;
          }
          else{//nums[i] ==0 
              for (int j=i+1;j<nums.length;j++)   {
               if(nums[j] == 0){//continue to the next element, as outer i will take care
                   continue;
               }else{ //swap the elements
                   int temp = nums[i];
                   nums[i] = nums[j];
                   nums[j] = temp;
                   break;
               }
           }
          }
      }        
  }
	
	public static void main(String args[]) {
		int a[] = {0,1,0,3,12};
		moveZeroes(a);
		System.out.println(Arrays.toString(a));
	}

}
