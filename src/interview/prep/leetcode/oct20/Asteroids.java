package interview.prep.leetcode.oct20;

import java.util.ArrayList;
import java.util.List;
/*
 * Asteroid Collision
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
Example 4:

Input: asteroids = [-2,-1,1,2]
Output: [-2,-1,1,2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 

Constraints:

1 <= asteroids <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */
public class Asteroids {
	
	public int[] asteroidCollision(int[] asteroids) {
		if(asteroids == null || asteroids.length <=1)
        	return asteroids;
		
		List<Integer> res = new ArrayList<>();
		
		res.add(asteroids[0]);
		int direction = (asteroids[0]>=0)?1:-1; 
		
		for(int i=1;i<asteroids.length;i++) {
			
			int currDirection =  (asteroids[i]>=0)?1:-1;
			int currSize = Math.abs(asteroids[i]); 
			
			if((currDirection + direction) == 0 ) {// there is a collision				
				for(int j=res.size()-1; j>=0;j--) {//resolve collision
					int lastSize = Math.abs(res.get(j)); 
					
					if(lastSize< currSize) { 
						res.remove(j); 
					}else {
						break; 
					}
				}
				
			}else {
				res.add(asteroids[i]);
			}
		}
		
		return res.parallelStream().mapToInt(i->i).toArray();
	} 
	

	
    public int[] _asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length <=1)
        	return asteroids; 
        
        List<Integer> right = new ArrayList<>(); 
        List<Integer> left = new ArrayList<>();
        for(int i=0; i<asteroids.length; i++) {
        	int temp = asteroids[i];
        	if(temp >=0)
        		right.add(temp); 
        	else 
        		left.add(temp*-1); 
        }
        
        List<Integer> rStable = findStable(right);
        List<Integer> lStable = findStable(left);
        
        return rStable.stream().mapToInt(i->i).toArray(); 
    }
	private List<Integer> findStable(List<Integer> lst){
		if(lst.size() <=1)
			return lst; 
		
		List<Integer> res = new ArrayList<>();
		int maxSpeed = lst.get(0); 
		for(int i=0; i<lst.size(); i++) {
			int temp = lst.get(i); 
			if(temp >= maxSpeed) {
				maxSpeed = temp;
				res.add(temp);
//				for(int j=0;j<res.size();j++) {
//					if(res.get(j) < maxSpeed)
//						res.remove(j); 
//				}
			}
		}
		return res; 
	}
	public static void main(String[] args) {
		int[] asteroids = {-10,-2,11}; 
		new Asteroids().asteroidCollision(asteroids); 

	}

}
