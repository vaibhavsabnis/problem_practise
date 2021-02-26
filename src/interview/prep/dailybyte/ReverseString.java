package interview.prep.dailybyte;
/*
Given a string, reverse all of its characters and return the resulting string.

Ex: Given the following strings...

“Cat”, return “taC”
“The Daily Byte”, return "etyB yliaD ehT”
“civic”, return “civic”
 */
public class ReverseString {

    //TC: O(N) ; SC: O(N) - where N = length of input string
    public  String reverseString(String input){
        if(input== null || input.length()<=1)
            return input;

        StringBuilder result = new StringBuilder();
        char[] ch = input.toCharArray();
        for(int i=ch.length-1; i>=0; i--){
            result.append(ch[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String str = "Cat";
        assertAnswer(rs.reverseString(str), new StringBuilder(str).reverse().toString());
        str = "The Daily Byte";
        assertAnswer(rs.reverseString(str), new StringBuilder(str).reverse().toString());
    }

    private static void assertAnswer(Object result, Object expected) {
        if(result ==null && expected !=null)
            throw new RuntimeException("Result is null while expected is not");

        System.out.println("Asserting Result : " + result + " with Expected value : "+ expected);
        assert result.equals(expected) : "Received = " + result + " Expected = " + expected;
    }
}
