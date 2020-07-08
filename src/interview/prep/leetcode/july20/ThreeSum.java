package interview.prep.leetcode.july20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 3Sum

Solution
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {
	class Triplet {
		public int x, y, z;
		int[] arr ;
		String strRep = null;

		public Triplet(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			arr= new int[] {x,y,z}; 
			Arrays.sort(arr);
			strRep = Arrays.toString(arr);
		}

		@Override
		public boolean equals(Object o) {
			Triplet t = (Triplet) o;
			if(this.strRep.equals(t.strRep))
				return true;
			return false; 
		}
		
		@Override
		public int hashCode() {
			return strRep.hashCode();
		}

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();

        if(nums.length < 3)
            return ans; 
        
		Set<Triplet> triplets = new HashSet<>();
		
        Map<Integer,Integer> numCnt = new HashMap<>(); 
        for(int i=0; i<nums.length; i++){
            numCnt.put(nums[i],i);
        }
        
                
        if(numCnt.size()==1 && nums[0] ==0) {
        	ans.add(Arrays.asList(new Integer[] {0,0,0}));
        	return ans; 
        }

		int x, y;//, z;
		for (int i = 0; i < nums.length; i++) {
			x = nums[i];
			// search for y & z
			for (int j = 0; j < nums.length; j++) {
				if (j == i)
					continue; // don't consider the number at the same position twice
				y = nums[j];

				int rem = -1*(x+y);
				if(numCnt.get(rem)!=null && numCnt.get(rem)!=i && numCnt.get(rem)!=j) {
					Triplet tup = new Triplet(x, y, rem);
					triplets.add(tup);				
				}
					
					/*
				for (int k = 0; k < nums.length; k++) {
					if (k == i || k == j)
						continue;

					z = nums[k];
					if (x+y+z==0) {
						Triplet tup = new Triplet(x, y, z);
						triplets.add(tup);
					}
				}
				*/
				
				
				
			}
		}

		triplets.forEach(a -> {
			List<Integer> lst = new ArrayList<>();
			lst.add(a.x);
			lst.add(a.y);
			lst.add(a.z);
			ans.add(lst);
		});
		
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
