package interview.prep.leetcode.mar21;

import interview.prep.leetcode.aug20.DistributeCandies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Distribute Candies
Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor.

The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.

Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.



Example 1:

Input: candyType = [1,1,2,2,3,3]
Output: 3
Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
Example 2:

Input: candyType = [1,1,2,3]
Output: 2
Explanation: Alice can only eat 4 / 2 = 2 candies. Whether she eats types [1,2], [1,3], or [2,3], she still can only eat 2 different types.
Example 3:

Input: candyType = [6,6,6,6]
Output: 1
Explanation: Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2 candies, she only has 1 type.


Constraints:

n == candyType.length
2 <= n <= 104
n is even.
-105 <= candyType[i] <= 105
 */
public class MaximizeCandies {
    public int distributeCandies(int[] candyType) {
        if(candyType == null || candyType.length == 0)
            return 0;
        int maxCanEat = (candyType.length)/2;

        Map<Integer,Integer> candyFreqMap = new HashMap<>();
        for(int candy: candyType){
            candyFreqMap.put(candy,candyFreqMap.getOrDefault(candy,0)+1);
        }

        maxCanEat = Math.min(maxCanEat, candyFreqMap.size());
//        System.out.println("Max Can Eat: " + maxCanEat);

        List<Integer> selectedCandyLst = new ArrayList<>();

        while(selectedCandyLst.size() < maxCanEat ){
            int selectedCandyCount = selectCandy(candyFreqMap,selectedCandyLst,maxCanEat);
            if(selectedCandyCount ==0)
                break;
        }
        return selectedCandyLst.size();
    }

    private int selectCandy(Map<Integer,Integer> candyFreq, List<Integer> selected, int limit){

        if(candyFreq ==null || candyFreq.size() == 0)
            return 0;

        for(int candyKey: candyFreq.keySet()){
            if(selected.size() >= limit)
                return 0;
            if(candyFreq.get(candyKey)>0){
                selected.add(candyKey);
                candyFreq.put(candyKey,candyFreq.get(candyKey)-1);
            }
        }
        return selected.size();
    }

    public static void main(String[] args) {
        MaximizeCandies ds = new MaximizeCandies();
        int[] candyArr = {1,1,2,3};
        System.out.println(ds.distributeCandies(candyArr));

    }

}
