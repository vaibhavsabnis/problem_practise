package interview.prep.leetcode.easy.mustdo;

import java.util.HashMap;
import java.util.Map;

public class IsHappyNumber {
    public boolean isHappy(int n) {
        if(n ==1)
            return true;

        Map<Integer,Integer> seen = new HashMap<>();

        return findDigitsSquare(n,seen);
    }

    private boolean findDigitsSquare(int n, Map<Integer,Integer> seen){
        if(n == 1)
            return true;

        if(seen.getOrDefault(n,0) > 1 ) // Only if you are seeing the 2nd time
            return false;

        int sum = 0;
        char[] nums = String.valueOf(n).toCharArray();
        for(char c:nums)
            sum += Character.getNumericValue(c)*Character.getNumericValue(c);

        System.out.println("Incoming num: " + n + ", sum of squares:" + sum);
        // if(!seen.add(sum)) return false;  // if the sum wasnt already present add, else return false as will go into cycle.
        seen.put(sum, seen.getOrDefault(sum,0)+1);

        return findDigitsSquare(sum,seen);
    }

    public static void main(String[] args) {
        IsHappyNumber num = new IsHappyNumber();
        System.out.println(num.isHappy(2));

    }
}
