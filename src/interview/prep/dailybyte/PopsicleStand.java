package interview.prep.dailybyte;

import java.util.HashMap;
import java.util.Map;

/*
This question is asked by Amazon. You’re running a popsicle stand where each popsicle costs $5.
Each customer you encountered pays with either a $5 bill, a $10 bill, or a $20 bill and only buys a single popsicle.
The customers that come to your stand come in the ordered given by the customers array where customers[i] represents the bill the ith customer pays with.
Starting with $0, return whether or not you can serve all the given customers while also giving the correct amount of change.

Ex: Given the following customers…

customers = [5, 10], return true
collect $5 from the first customer, pay no change.
collet $10 from the second customer and give back $5 change.

Ex: Given the following customers…

customers = [10], return false
collect $10 from the first customer and we cannot give back change.

Ex: Given the following customers…

customers = [5,5,5,10,20], return true
collect $5 from the first 3 customers.
collet $10 from the fourth customer and give back $5 change.
collect $20 from the fifth customer and give back $10 change ($10 bill and $5 bill).
 */
public class PopsicleStand {
    public boolean canServe(int[] bills){
        int five = 0, ten = 0;
        if(bills ==null || bills.length < 1)
            return false;
        for (int bill: bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
