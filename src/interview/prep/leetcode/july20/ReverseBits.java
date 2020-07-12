package interview.prep.leetcode.july20;

/*
 * Reverse Bits
Reverse bits of a given 32 bits unsigned integer.

 

Example 1:

Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: 11111111111111111111111111111101
Output: 10111111111111111111111111111111
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 

Note:

Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 

Follow up:

If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
	// you need treat n as an unsigned value
	public int _reverseBits(int n) {

//		System.out.println("Incoming Integer: " + n);
		String inStr = Integer.toBinaryString(n);
//		System.out.println("String rep of Incoming: " + inStr);
		
		boolean isNegative = inStr.charAt(0)=='0'? false:true ;
		inStr = inStr.substring(1, inStr.length());
		
		if(inStr.length() <31) {
			inStr = String.format("%"+31+"s", inStr).replace(' ', '0');
//			System.out.println("String rep of Incoming: " + inStr);
		}
		
		StringBuilder sb = new StringBuilder((isNegative)?"1":"0" + inStr);
		
		String outStr = sb.reverse().toString();
//		System.out.println("String rep of Outgoing: " + outStr);

		int out = Integer.parseInt(outStr.toString(), 2);
//		System.out.println("Outgoing Integer: " + out);

		return out;
	}

	public int reverseBits(String n) {

		StringBuilder sb = new StringBuilder(n);
		System.out.println("Incoming Integer:" + Integer.parseUnsignedInt(n, 2));
		System.out.println("String rep Incoming : " + n);

		String outStr = sb.reverse().toString();
		System.out.println("String rep of Outgoing: " + outStr);

		int out = Integer.parseUnsignedInt(outStr, 2);
		System.out.println("Outgoing integer: " + out);
		return out;
	}

	public static void main(String ar[]) {
		ReverseBits rb = new ReverseBits();
//		rb.reverseBits("00000010100101000001111010011100");
		rb.reverseBits("11111111111111111111111111111101");

		System.out.println("==========");

//		rb._reverseBits(43261596);
	}
}
