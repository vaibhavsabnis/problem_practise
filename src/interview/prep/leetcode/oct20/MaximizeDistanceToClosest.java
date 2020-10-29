package interview.prep.leetcode.oct20;
/*
 * Maximize Distance to Closest Person

Solution
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.

 

Example 1:


Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: seats = [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Example 3:

Input: seats = [0,1]
Output: 1
 

Constraints:

2 <= seats.length <= 2 * 104
seats[i] is 0 or 1.
At least one seat is empty.
At least one seat is occupied.
 */

import java.util.TreeSet;

public class MaximizeDistanceToClosest {
	public int maxDistToClosest(int[] seats) {
        if(seats.length ==2)
            return 1; 
        
        TreeSet<Integer> occupied = new TreeSet<>(); 
        
        for(int i=0; i<seats.length; i++){
            if(seats[i] ==1) 
                occupied.add(i); 
        }
        
        int maxDist = 1; 
        
        for(int i=0; i<seats.length; i++){
            if(seats[i] ==1)
                continue; 
            
            
            int lo = occupied.lower(i) ==null?0:occupied.lower(i); 
            int hi = occupied.higher(i) ==null?seats.length-1:occupied.higher(i);  
            int optimum = Math.min(i-lo , hi-i); 
            
            if(occupied.lower(i) ==null || occupied.higher(i)==null)
                optimum = Math.max(i-lo , hi-i);
            
            // System.out.println("hi:"+hi+", lo:"+lo +", i:"+i+", max:"+maxDist); 
            maxDist = Math.max(maxDist, optimum); 
            
            // System.out.println("For position i:"+i+", max distance after cals :"+maxDist); 
            
        }
        return maxDist; 
    }
}
/*
[1,0,0,0,1,0,1]
[1,0,0,0,1]
[1,0,0,0,0,0,1]
[1,0,0,0]
[0,0,0,0,1]
[0,1]

*/
