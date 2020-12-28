package interview.prep.leetcode.easy.mustdo;

import java.util.*;

/*
13. Roman to Integer
Share
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.

There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {
    Map<String, Integer> lookup = new HashMap<>();

    public int romanToInt(String s) {
        populateLookupMap();
        Queue<String> stk = new LinkedList<>();
        int res = 0;

        for (char c : s.toCharArray())
            stk.offer(Character.toString(c));
        String temp;
        while (!stk.isEmpty()) {
            temp = stk.poll();
            if (!stk.isEmpty() && lookup.get(temp + stk.peek()) != null)
                temp += stk.poll();
            res += lookup.get(temp);
        }

        return res;
    }

    private void populateLookupMap() {
        lookup.put("I", 1);
        lookup.put("V", 5);
        lookup.put("X", 10);
        lookup.put("L", 50);
        lookup.put("C", 100);
        lookup.put("D", 500);
        lookup.put("M", 1000);

        lookup.put("IV", 4);
        lookup.put("IX", 9);
        lookup.put("XL", 40);
        lookup.put("XC", 90);
        lookup.put("CD", 400);
        lookup.put("CM", 900);
    }

    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();
        for(String roman: rti.testCases())
            System.out.println("integer value of roman string = " + roman +" is: " + rti.romanToInt(roman));
    }
    private List<String> testCases(){
        List<String> res = new ArrayList<>();
        res.add("I");
        res.add("III");
        res.add("IV");
        res.add("IX");
        res.add("LVIII");
        res.add("MCMXCIV");

        return res;
    }
}
