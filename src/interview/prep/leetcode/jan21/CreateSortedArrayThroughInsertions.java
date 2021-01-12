package interview.prep.leetcode.jan21;

import java.util.SortedMap;
import java.util.TreeMap;

/*
Create Sorted Array through Instructions
Given an integer array instructions, you are asked to create a sorted array from the elements in instructions. You start with an empty container nums. For each element from left to right in instructions, insert it into nums. The cost of each insertion is the minimum of the following:

The number of elements currently in nums that are strictly less than instructions[i].
The number of elements currently in nums that are strictly greater than instructions[i].
For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1) (elements 1 and 2 are less than 3, element 5 is greater than 3) and nums will become [1,2,3,3,5].

Return the total cost to insert all elements from instructions into nums. Since the answer may be large, return it modulo 109 + 7



Example 1:

Input: instructions = [1,5,6,2]
Output: 1
Explanation: Begin with nums = [].
Insert 1 with cost min(0, 0) = 0, now nums = [1].
Insert 5 with cost min(1, 0) = 0, now nums = [1,5].
Insert 6 with cost min(2, 0) = 0, now nums = [1,5,6].
Insert 2 with cost min(1, 2) = 1, now nums = [1,2,5,6].
The total cost is 0 + 0 + 0 + 1 = 1.
Example 2:

Input: instructions = [1,2,3,6,5,4]
Output: 3
Explanation: Begin with nums = [].
Insert 1 with cost min(0, 0) = 0, now nums = [1].
Insert 2 with cost min(1, 0) = 0, now nums = [1,2].
Insert 3 with cost min(2, 0) = 0, now nums = [1,2,3].
Insert 6 with cost min(3, 0) = 0, now nums = [1,2,3,6].
Insert 5 with cost min(3, 1) = 1, now nums = [1,2,3,5,6].
Insert 4 with cost min(3, 2) = 2, now nums = [1,2,3,4,5,6].
The total cost is 0 + 0 + 0 + 0 + 1 + 2 = 3.
Example 3:

Input: instructions = [1,3,3,3,2,4,2,1,2]
Output: 4
Explanation: Begin with nums = [].
Insert 1 with cost min(0, 0) = 0, now nums = [1].
Insert 3 with cost min(1, 0) = 0, now nums = [1,3].
Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3].
Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3,3].
Insert 2 with cost min(1, 3) = 1, now nums = [1,2,3,3,3].
Insert 4 with cost min(5, 0) = 0, now nums = [1,2,3,3,3,4].
​​​​​​​Insert 2 with cost min(1, 4) = 1, now nums = [1,2,2,3,3,3,4].
​​​​​​​Insert 1 with cost min(0, 6) = 0, now nums = [1,1,2,2,3,3,3,4].
​​​​​​​Insert 2 with cost min(2, 4) = 2, now nums = [1,1,2,2,2,3,3,3,4].
The total cost is 0 + 0 + 0 + 0 + 1 + 0 + 1 + 0 + 2 = 4.


Constraints:

1 <= instructions.length <= 105
1 <= instructions[i] <= 105
 */
public class CreateSortedArrayThroughInsertions {
    public int createSortedArray(int[] instructions) {
        if (instructions.length <= 1)
            return 0;

        SortedMap<Integer, Integer> map = new TreeMap<>();
        int cost = 0;
        for (Integer i : instructions) {
            cost += calcInsertionCost(map, i);
            System.out.println("Accumulated Cost to insert i=" + i+" is = " + cost);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return cost % (int)(Math.pow(10,9) + 7);
    }

    private int calcInsertionCost(SortedMap<Integer, Integer> map, Integer i) {
        int headCost = 0;
//        if(map.get(i-1) !=null){
        SortedMap<Integer, Integer> headMap = map.headMap(i);//elements less than i as key(because api excludes i
        headCost = calcCost(headMap);
//        }

        int tailCost = 0;
//        if(map.get(i+1) !=null){
        SortedMap<Integer, Integer> tailMap = map.tailMap(i + 1);//elements greater than i as key (check api as it includes i)
        tailCost = calcCost(tailMap);
//        }
        return Math.min(headCost, tailCost);
    }

    private int calcCost(SortedMap<Integer, Integer> map) {
        int cost = 0;
        for (Integer key : map.keySet()) {
            int multiplier = map.get(key);
            cost += multiplier; //Same entry could be more than once
        }
        return cost;
    }

    public static void main(String[] args) {
        CreateSortedArrayThroughInsertions cs = new CreateSortedArrayThroughInsertions();
        int[] arr = {1, 2, 3, 6, 5, 4};
        int result = cs.createSortedArray(arr);
//        cs.evaluateTests();
    }

    private void evaluateTests() {
        int testNo = 0;
        int[] input = {1, 5, 6, 2};
        int output = createSortedArray(input);
        assertAnswer(output, 1);
        System.out.println(">>> Passed Test " + (++testNo));

        input = new int[]{1, 2, 3, 6, 5, 4};
        output = createSortedArray(input);
        assertAnswer(output, 3);
        System.out.println(">>> Passed Test " + (++testNo));

        input = new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2};
        output = createSortedArray(input);
        assertAnswer(output, 4);
        System.out.println(">>> Passed Test " + (++testNo));
    }

    private void assertAnswer(int result, int expected) {
        assert result == expected : "Received = " + result + " Expected = " + expected;
    }
 /*
 [1,5,6,2]
[1,3,3,3,2,4,2,1,2]
[1,2,3,6,5,4]
  */
}
