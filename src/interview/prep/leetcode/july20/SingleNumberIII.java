package interview.prep.leetcode.july20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Single Number III

Solution
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		if (nums.length <= 2)
			return nums;

		List<Integer> l = new ArrayList<>();
		Map<Integer, Integer> freq = new HashMap<>();
		for (int i : nums) {
			freq.put(i, freq.getOrDefault(i, 0) + 1);
		}
		Set<Integer> keys = freq.keySet();
		Iterator<Integer> iter = keys.iterator();
		int n = Integer.MIN_VALUE;
		while (iter.hasNext()) {
			n = (int) iter.next();
			if (freq.get(n) != 2)
				l.add(n);
		}
		return l.stream().mapToInt(Integer::intValue).toArray();
	}
}
