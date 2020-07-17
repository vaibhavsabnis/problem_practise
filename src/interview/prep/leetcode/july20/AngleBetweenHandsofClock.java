package interview.prep.leetcode.july20;

public class AngleBetweenHandsofClock {
	public double angleClock(int hour, int minutes) {

        if(hour ==12 && minutes ==0)
            return 0; 
        double min = 6*minutes; 
        double hr = 30*hour ;
        
        double hrOffset = 1*minutes*(0.5/30)*30;
        
        // System.out.println("Incoming Time Hour:" + hour + ",Min:" + minutes);
        // System.out.println("In degrees from reference point Hour:" + hr + ",Min:" + min + ", Offset: " + hrOffset);
        
        double lgAngle = Math.abs(min-(hr+hrOffset));
        double smAngle = 360- Math.abs(min-(hr+hrOffset)); 
        
        // System.out.println("Larger Angle:" + lgAngle + ", Smaller Angle: " + smAngle);
        
//         double degrees= Math.abs(min-(hr+hrOffset));
//         double degrees = Math.abs(min-hr);
        
//         degrees = (degrees<=180) ? (180-hrOffset) : (180+hrOffset);
        
        return (lgAngle>180 ? smAngle:lgAngle);
    }
}
