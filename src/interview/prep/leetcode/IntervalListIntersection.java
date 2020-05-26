package interview.prep.leetcode;

/*
 * Interval List Intersections
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 


Input:  A = [[0,2],[5,10],[13,23],[24,25]], 
		B = [[1,5],[8,12],[15,24],[25,26]]

Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 */
import java.util.*;

public class IntervalListIntersection {

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		if(A ==null || B==null)
			return new int[][] {}; 
		
		List<int[]> outList = new ArrayList<>();
		int aPtr = 0; 
		int bPtr = 0; 
		while (aPtr < A.length && bPtr < B.length) {
			int[] x = A[aPtr]; 
			int[] y = B[bPtr]; 

			if(isOverlapping(x,y)) {
				outList.add(new int[] {Math.max(x[0], y[0]), Math.min(x[1], y[1])});
			}
			int e1 = x[1];
			int e2 = y[1];
			if(e1>=e2)
				bPtr++;
			if(e2>=e1)
				aPtr++;
		}

		return outList.toArray(new int[outList.size()][]);
		
	}
	private boolean isOverlapping(int[] x, int[] y) {
		
		int s1= x[0];
		int s2 = y[0];
		int e1 = x[1];
		int e2 = y[1];
		
		if (e2>=s1 && e1>=s2)
			return true; 

		return false; 
	}

	public static void main(String[] args) {
		//A = [[0,2],[5,10],[13,23],[24,25]], 
		//B = [[1,5],[8,12],[15,24],[25,26]]
						
		int[][] A = {{0,2},{5,10},{13,23},{24,25}};
		int[][] B = {{1,5},{8,12},{15,24},{25,26}};
		
		IntervalListIntersection i = new IntervalListIntersection();
		System.out.println(i.intervalIntersection(A, B));
		
	}

}
