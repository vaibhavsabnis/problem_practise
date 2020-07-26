package interview.prep;

public class WaterBottleDrank {
	public int numWaterBottles(int numBottles, int numExchange) { //(15,4) (9,3)
        if(numBottles < numExchange)
            return numBottles; 
        
        int drank  = 0; 
        int empty = 0;        
        int full=numBottles;
        
        
        while(true){
        	int withMe = full + empty;
        	if (withMe<numExchange)
        		break;
        	
        	drank += full; 
            
            full = withMe/numExchange; 
            empty = withMe%numExchange;
        }
        return (drank+full);
        
        
        
        
        /*
        int drank  = 0; 
        int full=numBottles; 
        int remainder = 0; 
        int exchanged = 0;
        
        
        
       
        while((full+remainder) >=numExchange || full !=0){//15, 6, 3
            drank += full; //15+3+
            exchanged = (full+remainder)/numExchange; //3 1
            remainder = full%numExchange; //3 2
            full = exchanged;  //3 1
        }
        
        return (drank);
        */ 
    }
	
	public static void main(String[] ar) {
		WaterBottleDrank wd = new WaterBottleDrank(); 
		System.out.println(wd.numWaterBottles(15,4));
		System.out.println(wd.numWaterBottles(9,3));
		System.out.println(wd.numWaterBottles(5,5));
		System.out.println(wd.numWaterBottles(2,3));
		System.out.println(wd.numWaterBottles(15,8));
				
	}
}
