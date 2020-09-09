package interview.prep.leetcode.aug20;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if(pattern ==null || str ==null || str.length() == 0 || pattern.length()==0)
            return false; 
        Map<Character,String> mp = new HashMap<>(); 
        Map<String,Character> mp2 = new HashMap<>(); 
        
        char[] pchar = pattern.toCharArray(); 
        StringTokenizer  tok = new StringTokenizer(str," "); 
        
        StringBuffer newDelimSB = new StringBuffer(); 
        
        for(char c: pchar){
            String temp = tok.hasMoreTokens() ? tok.nextToken()+" " : null; 
            if (temp == null)
                return false; 
            
            //maintain map 1
            if(!mp.containsKey(c))
                mp.put(c,temp);
            
            if(!mp.get(c).equals(temp))
                return false; 
            
            //maintain map 2
            if(!mp2.containsKey(temp.trim()))
                mp2.put(temp.trim(),c);
            
            // System.out.println(mp2);
            // System.out.println("Working on char:" +c);
            
            if(!mp2.get(temp.trim()).equals(c))
                return false; 
            
            
            newDelimSB.append(temp);
        }
        System.out.println(mp);
        
        String newDelim = newDelimSB.toString().trim(); 
        
        StringTokenizer fin = new StringTokenizer(str,newDelim); 
        // int cnt = fin.countTokens(); 
        // if(cnt < 1)
        //     return false; //takes care of less than pattern 
        
        
        System.out.println("New Delim:"+ newDelim) ;
        while(fin.hasMoreTokens()){
            System.out.println("11") ;
            
            if(!newDelim.equals(fin.nextToken())){               
               return false; 
            }
        }
        
        return true; 
    }
	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		wp.wordPattern("aaa", "aa aa aa aa");
	}

}
