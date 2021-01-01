package interview.prep.leetcode.dec20;
/*
 * Valid Mountain Array

Solution
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < A[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
 */
public class ValidMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}public boolean validMountainArray(int[] arr) {
        if(arr.length < 3 || arr[0]>arr[1])
            return false; 
        
        int leftPeak = -2; 
        int leftPos = 0; 
        int rightPeak = -1; 
        int rightPos = arr.length-1; 
        
        // System.out.println("Starting: "); 
        
        //findPeak from left before first drop
        for(int i=0; i<arr.length-1;i++){
            if(arr[i] > leftPeak){
                leftPeak = arr[i]; 
                leftPos = i; 
            }
            else if(arr[i] < leftPeak){
                leftPos = i-1;   
                break; 
            }
            else if(arr[i] == leftPeak )
                return false; 
                          
        }
        
        System.out.println(" leftPeak: " + leftPeak + " , leftPos: " + leftPos); 
        
        //findPeak from right before first drop
        for(int j=arr.length-1; j>=0 ;j--){
            // System.out.println("Evaluating right position: "); 
            if(arr[j] > rightPeak){
                rightPeak = arr[j]; 
                rightPos = j;
            }
            else if(arr[j] == rightPeak ) //plateau identified
                return false; 
            else if(arr[j]< rightPeak){
                rightPos = j+1;    
                break; 
            }             
        }
        System.out.println(" rightPeak: " + rightPeak + " , rightPos: " + rightPos); 
        
        return (rightPos==leftPos); 

    }
    
}
/*
[1,3,2]
[1,2,3,2,1]
[2,1]
[3,5,5]
[3,5,2,1]
[0,3,2,1]
[0,2,3,4,5,2,1,0]
[0,2,3,3,5,2,1,0]
[1,2,3]
[9,8,7,6,5,4,3,2,1,0]
*/
