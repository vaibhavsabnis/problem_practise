package interview.prep.leetcode.dec20;

import java.util.HashSet;
import java.util.Set;

public class SongPairTotalDuration {
	    class Pair{
	        public int x; 
	        public int xPos;
	        public int y; 
	        public int yPos;         
	        public Pair(int _x, int _xPos, int _y, int _yPos){
	            x = _x; xPos = _xPos; 
	            y = _y; yPos = _yPos; 
	        }
	        public boolean equals(Object obj){
//	            if(!(obj instanceof this)) return false; 
	            Pair temp = (Pair)obj; 
	            if(this.x == temp.x && this.xPos == temp.xPos && 
	               this.y == temp.y && this.yPos == temp.yPos){
	                return true; 
	            }
	            return false; 
	        }
	        public int hashCode(){
	            int hash = 31*(x+xPos+y+yPos) +17; 
	            return hash; 
	        }
	    }
	    
	    public int numPairsDivisibleBy60(int[] time) {
	        int pairs = 0; 
	        Set<Pair> set = new HashSet<>(); 
	        
	        for(int i=0; i<time.length; i++){
	            int a = time[i]; 
	            for(int j=0;j<time.length; j++){
	                if(j==i) continue; 
	                int b = time[j];
	                if( (a+b)%60 ==0) {
	                    if(!set.contains(new Pair(a,j,b,i))){
	                        pairs++; 
	                        set.add(new Pair(a,i,b,j)); 
	                    }
	                }
	            }
	        }
	        return pairs; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
