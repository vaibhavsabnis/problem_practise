package interview.prep.leetcode.mar21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
916. Word Subsets
Medium

672

103

Add to List

Share
We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a.

Return a list of all universal words in A.  You can return the words in any order.



Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]


Note:

1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].
 */
public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = charFreq("");
        for (String b: B) {
            int[] bCount = charFreq(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        search: for (String a: A) {
            int[] aCount = charFreq(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    continue search;
            ans.add(a);
        }

        return ans;
    }

    //Logic is sound but gives TLE
    //TC:O(N*Nc * M*Mc),
    //SC: O(N + M)
    //N = num of words in A, M = num of words in B,
    //Nc = num of chars in each word ofA, Mc = num of chars in each word of B,
    public List<String> _wordSubsets(String[] A, String[] B) {
        List<String> answer = new ArrayList<>();
        //verify inputs
        if(A==null || B==null || A.length ==0 || B.length ==0)
            return answer;

        // main logic
        Map<String, int[]> subsetFreq = new HashMap<>();
        for(String subset: B){
            subsetFreq.put(subset, charFreq(subset));  //TC: O(M) , SC: O(M)
        }

        // System.out.println("Subset Freq : " + printMap(subsetFreq));

        for(String word: A){
            // System.out.println("Checking word: " + word);
            boolean isUniv = isUniversal(word, subsetFreq );
            if(isUniv){ //meat
                // System.out.println("Is word: Universal -> " + isUniv);
                answer.add(word);
            }
        }
        return answer;
    }

    private boolean isUniversal(String word, Map<String, int[]> subsetFreq ){

        int[] aFreq = charFreq(word);
        // System.out.println("word: " + word + " --> freq: " + printArray(aFreq));

        for(String subset: subsetFreq.keySet()){
            //All chars in B should be in A
            int[] bFreq = subsetFreq.get(subset); //charFreq(subset);

            //freq of all chars in b are atleast <= ones in word.

            // System.out.println("subset: " + subset + " --> having freq: " + printArray(bFreq));

            for(int i=0; i< bFreq.length; i++){
                char c = (char)('a' + i);
                // System.out.println("Checking freq of char : " + c + " in subset: " + bFreq[i]);
                if(bFreq[i] == 0)
                    continue;

                if(! (bFreq[i] <= aFreq[i])) {
                    // System.out.println(" >> Freq mismatch : subset freq " + bFreq[i] + " word char freq: " + aFreq[i] );
                    return false;
                }
            }
        }
        return true;
    }

    //TC: O(N), SC : O(alphabet size)
    private int[] charFreq(String word){
        int[] freq = new int[26];
        for(char c: word.toCharArray()){
            freq[c-'a']++;
        }

        return freq;
    }

    private String printArray(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i: arr){
            sb.append(i + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    private String printMap(Map<String, int[]> map){
        StringBuilder sb = new StringBuilder();
        sb.append("{" + "\n");
        for(String key: map.keySet()){
            sb.append(key + " -> " + printArray(map.get(key)));
            sb.append("\n");
        }
        sb.append("}" + "\n");
        return sb.toString();
    }
}
/*
["amazon","apple","facebook","google","leetcode"]
["e","o"]
["amazon","apple","facebook","google","leetcode"]
["l","e"]
["amazon","apple","facebook","google","leetcode"]
["e","oo"]
["amazon","apple","facebook","google","leetcode"]
["lo","eo"]
["amazon","apple","facebook","google","leetcode"]
["ec","oc","ceo"]
*/
