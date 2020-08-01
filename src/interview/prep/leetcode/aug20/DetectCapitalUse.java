package interview.prep.leetcode.aug20;

public class DetectCapitalUse {
	 public boolean detectCapitalUse(String word) {
	        if(word==null)
	            return false; 
	        if(word.trim().isEmpty()|| word.length() ==1)
	            return true;
	        
	        char first= word.charAt(0);
	        char second = word.charAt(1);
	        //0=All caps,2=All small,1=Camel Case
	        int condition = -1; 
	        
	        if(isCapsCase(first)){
	            if(isCapsCase(second)) condition = 0; 
	            else condition = 1;
	        }
	        else condition = 2;
	            
	        for(int i=0; i<word.length();i++){
	            boolean isCaps = isCapsCase(word.charAt(i));
	            boolean isSmallCase = isSmallCase(word.charAt(i));
	            if(condition ==0 && !isCaps)
	                return false; 
	            if(condition == 2 && !isSmallCase)
	                return false; 
	            if(condition ==1){
	                if(i==0 && !isCaps)
	                    return false; 
	                if(i>0 && isCaps)
	                    return false;
	            }
	        }
	        return true; 
	    }
	    private boolean isCapsCase(char c){
	        return Character.isUpperCase(c); 
	    }   
	    
	    private boolean isSmallCase(char c){
	        return Character.isLowerCase(c); 
	    }
	    public static void main(String ar[]) {
	    	DetectCapitalUse dc = new DetectCapitalUse();
	    	dc.detectCapitalUse("FlaG");
	    }
}
