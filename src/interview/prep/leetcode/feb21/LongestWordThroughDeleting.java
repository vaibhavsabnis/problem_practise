package interview.prep.leetcode.feb21;

import java.util.*;

public class LongestWordThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d,
                (a,b) -> {
                    if(a.length() < b.length()) return 1;
                    else if(a.length() > b.length()) return -1;
                    else {
                        return a.compareTo(b);
                    }
                });

        for(String dictWord: d){
            if(isSubsequence(dictWord, s))
                return dictWord;
        }

        return "";

    }

    private boolean isSubsequence(String dictWord, String s){
        int j = 0;
        for(int i=0; i<s.length() && j < dictWord.length(); i++){
            if(s.charAt(i) == dictWord.charAt(j))
                j++;
        }
        return j>= dictWord.length();
    }
    public String _findLongestWord(String s, List<String> d) {
        Collections.sort(d,
                (a,b) -> {
                    if(a.length() < b.length()) return 1;
                    else if(a.length() > b.length()) return -1;
                    else {
                        return a.compareTo(b);
                    }
                });

        System.out.println("Sorted Dictionary: " + d);

        Map<Character, List<Integer>> sFreqPosn = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            List<Integer> l = sFreqPosn.getOrDefault(s.charAt(i), new ArrayList<>());
            l.add(i);
            sFreqPosn.put(s.charAt(i), l);
        }
        // System.out.println("sFreqPosn " + sFreqPosn);

        //"abpecpla"
        //[monkey, apple, bcple, bpple, plea, ale]
        for(String dict: d){

            // System.out.println("Checking String : "+ dict + " for presence in string s");
            int lastFoundChar =0;
            for(int i=0; i<dict.length(); i++){
                Character c = dict.charAt(i);
                List<Integer> pos = sFreqPosn.get(c);

                if(pos == null || pos.size() == 0) {// character not present in string or used up
                    break;
                }else{
                    if(pos.get(0) < lastFoundChar)
                        break;

                    lastFoundChar = pos.get(0);
                    pos.remove(0);
                    if(i == dict.length()-1) // last character was found
                        return dict;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        LongestWordThroughDeleting l = new LongestWordThroughDeleting();
        List<String> dict = Arrays.asList(new String[] {"ba","ab","a","b"});
        System.out.println(l.findLongestWord("bab", dict));
    }
}
/*
"bab"
["ba","ab","a","b"]
"abpecpla"
["ale","apple","monkey","plea","bpple","bcple"]
"abpcplea"
["ale","apple","monkey","plea","bpple","bcple"]
"abpcplea"
["a","b","c"]
*/
