package interview.prep.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*

We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000

 */
public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i:stones) {
			maxHeap.add(i);
		}
		
		while (!maxHeap.isEmpty()) {
			
			if (maxHeap.size() ==1)
				return maxHeap.poll();
			
			int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE; 
			
			if(maxHeap.peek()!=null)
				y=maxHeap.poll();
			if(maxHeap.peek()!=null)
				x=maxHeap.poll();
			
			if(x<y)
				maxHeap.add(y-x);
			
		}
		return 0;
		
	}
	
	public static void main(String arg[]) {
		System.out.println(new LastStoneWeight().lastStoneWeight(new int[] {1,3}));
	}
	/*
	public int _lastStoneWeight(int[] stones) {

		int len = stones.length;
		Arrays.parallelSort(stones);
		int a[] = Arrays.copyOf(stones, len);

		for (int i = len - 1; i <= 0; i--) {
			
			int x = a[i-1];
			int y = a[i];
			
			int smashResult = (x>=y)?0:y-x;//smashStones(x, y);
			stones[i] = 0;
			stones[i-1] = smashResult;
			
			a = Arrays.copyOfRange(a,0,len-1); 
			Arrays.parallelSort(a);
		}
		
	}
	
	private int smashStones(int x,int y) {
		if (x>=y)
			return 0; 
		return y-x;
	}
*/
}
