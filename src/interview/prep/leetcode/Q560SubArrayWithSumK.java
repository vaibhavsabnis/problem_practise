package interview.prep.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q560SubArrayWithSumK {

	public int subarraySum(int[] nums, int k) {

		Map<Integer, Integer> sumLookup = new HashMap<>();
		sumLookup.put(0, 1);
		int totalSums = 0;
		int runningSum = 0;

		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];

			if (sumLookup.containsKey(runningSum - k)) {
				totalSums += sumLookup.get(runningSum - k);
			}
			sumLookup.put(runningSum, sumLookup.getOrDefault(runningSum, 0) + 1);

		}
		return totalSums;
	}

	public void myWrapper(int[] nums, int k) {
		System.out.println(subarraySum (nums,k));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
