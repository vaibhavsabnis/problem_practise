package interview.prep.leetcode.jan21;

public class LongestStringNoRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        String maxLenStr = "";
        if(s ==null || s.isEmpty())
            return maxLen;
        if(s.length() == 1)
            return 1;

        int st=0;
        int en=1;
        char[] ch = s.toCharArray();
        // Set<Character> charset = new HashSet<>();

        String temp = ch[0]+"";
        while(st<=en && en < ch.length){
            if(!isPresent(ch[en], temp)){
                temp += ch[en];
                en++;
                if(maxLen <= temp.length()) maxLenStr =temp;
                maxLen = Math.max(maxLen, temp.length());

            }else{
                st++;
                temp = temp.substring(1);
            }
        }

        System.out.println("Max Length: " + maxLen + ", MaxLenString = " + maxLenStr);
        return maxLen;
    }
    private boolean isPresent(char c, String lookup){
        return lookup.contains(c+"");
    }

    public static void main(String[] args) {
        LongestStringNoRepeatChar ls = new LongestStringNoRepeatChar();
        int res = ls.lengthOfLongestSubstring("dvdf");
        ls.assertAnswer(res,3);
    }
    private void assertAnswer(int result, int expected){
        assert  result == expected : "Received = "+ result + " Expected = " + expected;
    }
}
/*
"abcabcbb"
"bbbbb"
"pwwkew"
""
"dvdf" : 3
*/
