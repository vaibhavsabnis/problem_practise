package interview.prep.leetcode.july20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
	public static void main(String args[]) {
		Subsets pwrSet = new Subsets();
		System.out.println(pwrSet.subsets(new int[] { 1, 2, 3, 4}));
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		if (nums.length == 0)
			return res;

		int len = 1 << nums.length;

		for (int i = 0; i < len; i++) {
			String bin = Integer.toBinaryString(i);
			bin = String.format("%"+nums.length+"s", bin).replace(" ", "0");
			res.add(addPowerSet(bin,nums));
		}
		return res;
	}
	
	private List<Integer> addPowerSet(String binRep,int[] nums) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < binRep.length(); i++) {
			char c = binRep.charAt(i);
			if(Character.toString(c).equals("1"))
				l.add(nums[i]);
		}
		return l; 
	}
}
