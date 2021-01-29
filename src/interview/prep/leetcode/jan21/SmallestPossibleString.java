package interview.prep.leetcode.jan21;

import java.util.Arrays;

public class SmallestPossibleString {

    public String getSmallestString(int n, int k) {
        char[] ch = new char[n];
        Arrays.fill(ch,'a');

        if(n==k)
            return String.valueOf(ch);

        k -=n;
        int i=n-1;
        while(k>0){
            ch[i] = (char)('a'+ Math.min(25,k));
            i--;
            k -=Math.min(25,k);
        }
        System.out.println(Arrays.toString(ch));
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        SmallestPossibleString s = new SmallestPossibleString();
        s.getSmallestString(5,73);
    }
}
