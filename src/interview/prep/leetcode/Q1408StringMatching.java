package interview.prep.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 1408. String Matching in an Array
User Accepted:6393
User Tried:6556
Total Accepted:6675
Total Submissions:11825
Difficulty:Easy
Given an array of string words. Return all strings in words which is substring of another word in any order. 

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

 

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
It's guaranteed that words[i] will be unique.
 */
public class Q1408StringMatching {
	
	public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        outer: for (int i= 0 ; i<words.length; i++){
            String word = words[i];
            for (int j = 0; j<words.length; j++){
                if (i!=j){
                    if (words[j].contains(word)){
                        result.add(word);
                        continue outer; 
                    }
                }
            }
        }
        return result;
    }

	public static void main(String args[]) {
		System.out.println(new Q1408StringMatching().stringMatching(new String[] {"mass","as","hero","superhero"}));
		System.out.println(new Q1408StringMatching().stringMatching(new String[] {"leetcode","et","code"}));
		System.out.println(new Q1408StringMatching().stringMatching(new String[] {"blue","green","bu"}));
	}
}
