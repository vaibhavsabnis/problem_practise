package interview.prep;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data 
public class SlidingWindow {
	
	//Given an int array of size n, find the average of sum of sub-arrays of size k
	private int k = 4;
	private int n = 1000000;			
	private int[] a = new int[n];
	
	
	public SlidingWindow(){
		int i = 0; 
		while(i<n) { // assign values to the array [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
			a[i] =i++;
		}
	}
			
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(new SlidingWindow().solution1());
		System.out.println("Time taken (in milliseconds): " + (System.currentTimeMillis() - start));
				
		start = System.currentTimeMillis();
		System.out.println(new SlidingWindow().solution2());
		System.out.println("Time taken (in milliseconds): " + (System.currentTimeMillis() - start));
	}
	
	//BigOh(n * k)
	private int solution1() { 
		
		if(n==0) return 0;
		long grandTotal=0; 
		List<Integer> lstSubArraySum = new ArrayList<Integer>(); 	
		
		for (int i=0;i<=(n-k);i++) {
			int sum = 0; 
			for(int j=i; j<(k+i); j++ ) {
				sum +=a[j];
			}
			lstSubArraySum.add(sum);
		}
		
		for(int i:lstSubArraySum) {
			grandTotal += i;
		}
		
		return Math.round(grandTotal/lstSubArraySum.size());		
	}
	
	//BigOh(n)
	//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	private int solution2() {		
		if(n==0) return 0;
		
		long grandTotal=0; 
		List<Integer> lstSubArraySum = new ArrayList<Integer>(); 	
		
		int currentSum =0;
		
		for (int i=0; i<n ;i++) {			
			currentSum += a[i];			
			if((i+1) == k ) { //counted 1st k elements
				lstSubArraySum.add(currentSum);
			}
			if(i>=k) {//every subsequent element post index k-1
				currentSum -= a[i-k]; //remove (i-k)th value
				lstSubArraySum.add(currentSum);
			}
		}
		
		for(int i:lstSubArraySum) {
			grandTotal += i;
		}		
		return Math.round(grandTotal/lstSubArraySum.size());		
	
	}

}
