package interview.prep.bloomberg;

import java.util.HashSet;
import java.util.Set;

/*
 * Remove Duplicate from a string maintaining the sequence of chars
 * eg.i/p = "aabbccz$" -- o/p = "abcz$"
 * i/p = "zaabbccz$" -- o/p = "zabc$"
 */
public class RemoveDuplicate {
	
	private String removeDupe(String s) {
		//Check boundary conditions
		if(s == null || s.length()==0 || s.length()==1)
			return s; 
		
		//Main Logic
		StringBuffer sb = new StringBuffer();
		Set<Character> lookup = new HashSet<>();
		
		for(int i = 0 ; i < s.length(); i++) {
			
			Character c = s.charAt(i);
			
			if(!lookup.contains(c)) {
				sb.append(c);
				lookup.add(c);
			} 
		}

		//Return values
		return sb.toString();
	}
	
	public static void main(String a[]) {
		RemoveDuplicate rd = new RemoveDuplicate(); 
		System.out.println("After Removing Dupe -->"+ rd.removeDupe("aabbccz$"));
		System.out.println("After Removing Dupe -->"+ rd.removeDupe("zaabbccz$"));
	}

}
