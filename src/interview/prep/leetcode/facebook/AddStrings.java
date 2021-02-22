package interview.prep.leetcode.facebook;

public class AddStrings {
    public String addStrings(String num1, String num2) {

        StringBuilder res = new StringBuilder();

        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry= 0;

        while(i >= 0 || j >= 0){
            int sum = 0;
            if(i>=0){
                sum += Character.getNumericValue(num1.charAt(i));
                i--;
            }
            if(j>=0){
                sum += Character.getNumericValue(num2.charAt(j));
                j--;
            }

            sum +=carry;

            res.append(sum%10);
            carry = sum/10;
        }
        if(carry !=0)
            res.append(carry);

        if(res.length() == 0)
            res.append("0");

        return res.reverse().toString();

    }

    public static void main(String[] args) {
        AddStrings a = new AddStrings();
        a.addStrings("999","9999");

    }
}
/*
"0"
"0"
"9"
"2"
"100"
"11009"
"999"
"9999"
 */
