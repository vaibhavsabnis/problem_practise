package interview.prep.leetcode.facebook;
/*
67. Add Binary
Easy

2526

328

Add to List

Share
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

//         char[] A = a.toCharArray();
//         char[] B = b.toCharArray();

        int carry = 0;
        int Ai = a.length()-1;
        int Bi = b.length()-1;

        while(Ai >=0 || Bi >= 0){
            int sum = carry;
            if(Ai >=0){
                sum += a.charAt(Ai--) -'0';
            }
            if(Bi >=0){
                sum += b.charAt(Bi--) -'0';
            }
            sb.append(sum%2);
            carry = sum/2;
        }
        if(carry!=0)
            sb.append(carry);

        return sb.reverse().toString();
    }
}
