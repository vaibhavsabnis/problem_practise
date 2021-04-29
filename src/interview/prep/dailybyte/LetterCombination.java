package interview.prep.dailybyte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
17. Letter Combinations of a Phone Number
Medium

5881

520

Add to List

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.





Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty())
            return result;

        Map<Integer, String> numMap = new HashMap<>();
        numMap.put(0, "");
        numMap.put(1, "");
        numMap.put(2, "abc");
        numMap.put(3, "def");
        numMap.put(4, "ghi");
        numMap.put(5, "jkl");
        numMap.put(6, "mno");
        numMap.put(7, "pqrs");
        numMap.put(8, "tuv");
        numMap.put(9, "wxyz");

        helper(digits, numMap, result, 0, "");

        return result;
    }

    private void helper(String digits, Map<Integer, String> numMap, List<String> result, int pos, String curr) {
        if (pos == digits.length()) {
            result.add(curr);
            return;
        }

        int digit = digits.charAt(pos) - '0';

        for (char c : numMap.get(digit).toCharArray()) {
            helper(digits, numMap, result, pos + 1, curr + c);
        }

    }
}