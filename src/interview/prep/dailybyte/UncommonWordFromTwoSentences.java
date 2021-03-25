package interview.prep.dailybyte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
884. Uncommon Words from Two Sentences
Easy

581

105

Add to List

Share
We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words.

You may return the list in any order.



Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]


Note:

0 <= A.length <= 200
0 <= B.length <= 200
A and B both contain only spaces and lowercase letters.

===
Given two strings representing sentences, return the words that are not common to both strings (i.e. the words that only appear in one of the sentences). You may assume that each sentence is a sequence of words (without punctuation) correctly separated using space characters.

Ex: given the following strings...

sentence1 = "the quick", sentence2 = "brown fox", return ["the", "quick", "brown", "fox"]
sentence1 = "the tortoise beat the haire", sentence2 = "the tortoise lost to the haire", return ["beat", "to", "lost"]
sentence1 = "copper coffee pot", sentence2 = "hot coffee pot", return ["copper", "hot"]
 */
public class UncommonWordFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {

    Map<String,Integer> freq = new HashMap<>();
    for(String s: A.split(" ")){
        freq.put(s,freq.getOrDefault(s,0)+1);
    }

    for(String s: B.split(" ")){
        freq.put(s,freq.getOrDefault(s,0)+1);
    }

    List<String> res = new ArrayList<>();
    for(String key: freq.keySet()){
        if(freq.get(key) >1 )
            continue;

        res.add(key);
    }

    return res.stream().toArray(String[] ::new);
}
}
/*
"this apple is sweet"
"this apple is sour"
"apple apple"
"banana"
*/
