package interview.prep.leetcode.july20;
/*
 * Hamming Distance
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
	
	private String padZeroes(String s, int num) {
		while(num-->0) {
			s = "0"+s;
		}
		return s;
	}
	
	public int hammingDistance(int x, int y) {
		
		String sX = getBinaryRep(x);
		String sY = getBinaryRep(y);
		
		int lenX = sX.length();
		int lenY = sY.length();
		
		if (lenX !=lenY) {
			if (lenX>lenY)
				sY = padZeroes(sY, lenX-lenY);
			else
				sX = padZeroes(sX, lenY-lenX);
		}

		System.out.println(sX.toString()+" is Binary representation of "+ x);
		System.out.println(sY.toString()+" is Binary representation of "+ y);
		
        char[] cX = sX.toCharArray();
        char[] cY = sY.toCharArray();
        
        int hammingDist = 0;
        for(int i=0; i<cX.length;i++){
        	if(cX[i] !=cY[i])
        		hammingDist++; 
        }
        return hammingDist;
    }

	private String getBinaryRep (int num) {
		num = Math.abs(num);
		StringBuffer ans = new StringBuffer();
		bin(num,ans);
		return ans.toString(); 
	}
	private void bin(int n,StringBuffer buf){
		if(n>1)
			bin(n/2, buf);
		buf.append(n%2);
	}
	
	public static void main(String[] args) {
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.hammingDistance(15,-1));
		/*
		System.out.println(new HammingDistance().getBinaryRep(5));
		System.out.println(new HammingDistance().getBinaryRep(2));
		System.out.println(new HammingDistance().getBinaryRep(Integer.MAX_VALUE));
		System.out.println(new HammingDistance().getBinaryRep(Integer.MIN_VALUE));
		*/
	}

}
