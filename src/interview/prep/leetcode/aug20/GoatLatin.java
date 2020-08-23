package interview.prep.leetcode.aug20;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
Goat Latin
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Imaa peaksmaaa oatGmaaaa atinLmaaaaa
Imaa peaksmaaa oatGmaaaa atinLmaaaaa
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
*/
public class GoatLatin {
    public String toGoatLatin(String S) {
    	if(S.trim().isEmpty())
    		return S;
    	
        StringTokenizer st = new StringTokenizer(S," ");
        StringBuilder sb = new StringBuilder();
        int wordIndex = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
        
        String constant = "ma";
        while(st.hasMoreTokens()){
        	wordIndex++;
            String temp = st.nextToken();
            Character first = temp.charAt(0);
            
            if(vowels.contains(Character.toLowerCase(first))) {
            	sb.append(temp).append(constant);
            }else {
            	if(temp.length()>1)
            		sb.append(temp.substring(1)).append(first).append(constant);
            	else
            		sb.append(temp).append(constant);
            }
            populateA(sb,wordIndex);
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
    
    private void populateA(StringBuilder sb, int wordIndex) {
    	for(int i=0; i<wordIndex;i++) {
        	sb.append('a');
        }
    }
    
    public static void main(String[] args) {
    	GoatLatin gl = new GoatLatin(); 
    	String S = "The quick brown fox jumped over the lazy dog"; //"The quick brown fox jumped over the lazy dog"
    	System.out.println(gl.toGoatLatin(S)); 
    }
    
}
