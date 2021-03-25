package interview.prep.leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
    public String _minWindow(String s, String t) {

        Map<Character,Integer> tFreq = buildCharFreq(t);

        int left = 0;
        int right = left;
        String bestAns = "";

        while(right < s.length() && left <= right){
            String subStr = s.substring(left,right+1);

            // System.out.println("Value of left= " + left +", value of right = "+ right + " substring to eval = " + subStr);

            if(doesSatisfy(subStr, tFreq)){
                // System.out.println ("Found an answer>>> :"+ subStr + " Now will try to shrink window");

                if(bestAns.isEmpty() || bestAns.length() > subStr.length())
                    bestAns = subStr;

                INNER: while(++left <= right){//try to minimize window
                    subStr = s.substring(left,right+1);
                    if(doesSatisfy(subStr, tFreq)){
                        // System.out.println ("Found an better answer>>> :"+ subStr);

                        if(bestAns.isEmpty() || bestAns.length() > subStr.length())
                            bestAns = subStr;
                    }else{
                        // System.out.println("Breaking inner");
                        break INNER;
                    }
                }
            }
            // System.out.println("Moving to next right value ");
            // increase the window
            right++;

        }

        return bestAns;
    }

    private Map<Character,Integer> buildCharFreq(String t){
        Map<Character,Integer> freq = new HashMap<>();

        for(char c: t.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        // System.out.println("Character freq is: " + freq);
        return freq;
    }

    private boolean doesSatisfy(String s, Map<Character,Integer> freq){
        Map<Character,Integer> sFreq = new HashMap<>();
        // System.out.println("String s =" + s + " being checked against t char freq");
        for(char c: s.toCharArray()){
            sFreq.put(c,sFreq.getOrDefault(c,0)+1);
        }
        // System.out.println("Substring char freq: " + sFreq);

        for(char key:freq.keySet()){
            if(sFreq.get(key)==null || sFreq.get(key) < freq.get(key)){
                // System.out.println("Returning false from char freq for string "+ s);
                return false;
            }
        }
        // System.out.println("Returning true from char freq for string " + s);
        return true;
    }

    public static void main(String ar[]){
        MinimumWindowSubstring ms =new MinimumWindowSubstring();
        ms.minWindow("ADOBECODEBANC", "ABC");
    }
}
/*
"bdab"
"ab"
"ADOBECODEBANC"
"ABC"
"aat"
"t"
"a"
"t"
*/