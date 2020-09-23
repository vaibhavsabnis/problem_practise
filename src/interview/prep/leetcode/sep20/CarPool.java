package interview.prep.leetcode.sep20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Car Pooling

Solution
You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 */
public class CarPool {
	public boolean carPooling(int[][] trips, int capacity) {
		// sanitize
		int remCap = capacity;
		// int usedCap = capacity-remCap;

		Arrays.sort(trips, (t1, t2) -> t1[1] - t2[1]);
		// System.out.println(Arrays.deepToString(trips));
		// trip[i] = [num_passengers, start_location, end_location]
		Map<Integer, Integer> hopOutMap = new HashMap<>();

		for (int i = 0; i < trips.length; i++) {
			int[] currTrip = trips[i];
			int hopIn = currTrip[0];
			int hopOut = getTotalHopOut(hopOutMap, currTrip[1]);

			remCap += hopOut; // drop-off
			if (hopIn > (remCap)) // capacity breached.
				return false;

			// capacity available
			remCap -= hopIn; // pick-up
			hopOutMap.put(currTrip[2], hopOutMap.getOrDefault(currTrip[2], 0) + hopIn);
		}
		return true;
	}

	private int getTotalHopOut(Map<Integer, Integer> hopOutMap, int currStop) {
		int totalHopout = 0;
		for (int stop : hopOutMap.keySet()) {
			if (stop > currStop)
				continue;
			if (hopOutMap.get(stop) != null && hopOutMap.get(stop) != 0) {
				totalHopout += hopOutMap.get(stop);
				hopOutMap.put(stop, 0);
			}
		}
		return totalHopout;
	}

	/*

[[2,1,5],[3,3,7]]
5
[[2,1,5],[3,3,7]]
4
[[2,1,5],[3,5,7]]
3
[[3,2,7],[3,7,9],[8,3,9]]
11
[[3,2,8],[4,4,6],[10,8,9]]
11
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
