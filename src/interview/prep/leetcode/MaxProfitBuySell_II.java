package interview.prep.leetcode;

/*
 * Q 122
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 */
public class MaxProfitBuySell_II {
	
	public static int _maxProfit(int[] prices) {
		//System.out.println("Incoming prices stream:" +Arrays.toString(prices));
        int maxProfit =0;
        
        
        buy: for(int i=0; i<prices.length;i++){
            if(i>=prices.length-1)
                break;//or continue as we reached the end of the loop

            int buyPrice = prices[i];
            
            sell: for(int j=i+1;j<prices.length;j++){
                int sellPrice = prices[j];
                
                if (j>=prices.length-1) {//at last index
                	if(sellPrice >buyPrice) {

                    	//System.out.println("buyPrice at index:"+i +" = "+buyPrice);
                    	//System.out.println("sellPrice at index:"+j +" = "+sellPrice);
                    	
                        maxProfit += (sellPrice-buyPrice);
                        //System.out.println("Current profit:" + (sellPrice-buyPrice));
                        i=j;//Loop increment will take care of incrementing to next position
                	}
                	break sell;	
                }
                
                if (sellPrice < prices[j+1]) {//Get best sell price
                	continue sell;
                }
                
                if(sellPrice > buyPrice){
                	//System.out.println("buyPrice at index:"+i +" = "+buyPrice);
                	//System.out.println("sellPrice at index:"+j +" = "+sellPrice);
                	
                    maxProfit += (sellPrice-buyPrice);
                    //System.out.println("Current profit:" + (sellPrice-buyPrice));
                    i=j;//Loop increment will take care of incrementing to next position
                    continue buy;
                }  
            }
        }
        return maxProfit;
	}
	
	
	public static int maxProfit(int[] prices) {
		if (prices == null)
			return 0;
		if (prices.length == 0 || prices.length==1) {
			return 0;
		}
				
		int profit = 0;
		
		for (int i = 0; i<prices.length-1;i++){
			if(prices[i]< prices[i+1])
				profit += prices[i+1]-prices[i];
		}
		return profit;
	}
	
	public static void main(String args[]) {
		int a[] = {7,1,5,3,6,4};
		int b[] = {1,2,3,4,5};
		int c[] = new int[]{7,6,4,3,1};
		int d[] = {6,1,3,2,4,7};
		
		System.out.println(maxProfit(a) + " :--: " +_maxProfit(a));
		System.out.println(maxProfit(b) + " :--: " +_maxProfit(b));
		System.out.println(maxProfit(c) + " :--: " +_maxProfit(c));
		System.out.println(maxProfit(d) + " :--: " +_maxProfit(d));
	}
}
