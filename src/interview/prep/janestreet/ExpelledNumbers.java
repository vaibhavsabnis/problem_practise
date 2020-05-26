package interview.prep.janestreet;

import java.util.ArrayList;

import java.util.*;
/*
 * https://www.janestreet.com/puzzles/current-puzzle/ --> check archives for May 2020 challenge. 
 */
public class ExpelledNumbers {
	
	
	private List<Integer> fillList(int maxCount){
		List<Integer> res = new ArrayList<>();
		res.add(-1);//To 0th position
		
		for(int i=1; i<=maxCount;i++) {
			res.add(i);
		}
		return res;	
	}
	
	private void solvePuzzle(int maxNumber) {
		List<Integer> orig = fillList(maxNumber);
		Map<Integer,Integer> xplNos = new TreeMap<>();

		System.out.println("Incoming original List values: " + orig);
		
		int xplPos = 1;
		
		for(int i=1; i<orig.size()/2; i++) {
//		boolean found = false;
//		int i = 0; 
//		while(found == false) {
//			if(orig.get(1) ==1 && orig.get(2)==75 && orig.get(3)==2) {
//				System.out.println("***** YAY- Found **** on Run : " + i);
//				found = true;
//			}
			
			int NoBeingExpelled = orig.get(xplPos); 
			
			//System.out.print("Run : " + i + ", Expelled :" +xplPos+ " Expelled Number :"+ NoBeingExpelled + "--> ");
			
			xplNos.put( xplPos,orig.get(xplPos));

			if(NoBeingExpelled == 11) {
				System.out.println("***** YAY- Found **** on Run : " + i);
				break;
			}
			
			modifyBasedOnSpan(orig,xplPos);		
			

			System.out.println("Run is :" +i+", Number 11 is on: " + orig.indexOf(11));
			
			xplPos++;
		}
		System.out.println("Expelled List: " + xplNos);
	}
	
	private void modifyBasedOnSpan(List<Integer> orig, int pos){
		int xplNum = orig.get(pos);
		
		if(pos == 1) {
			orig.remove(pos);
			
			//Remove from current position, and add it back to the end
			//orig.add(xplNum);
			
			//System.out.println("Original List modified to : " + orig);
			return;
		}
		
		int lBound = 1;		
		int rBound = (2 * pos) - 1; //List is 0 based
		
		int i = pos-1;
		int j = pos+1;
		List<Integer> subList = new ArrayList<>();
		
		for(;i>=lBound && j<=rBound ;i--,j++) {
			subList.add(orig.get(i));
			subList.add(orig.get(j));
		}
		//System.out.print("New sublist will be : " + subList);
		
		for(int p=1;p<=rBound;p++) {
			orig.remove(1);
		}
		orig.addAll(1, subList);
		
		//Remove from current position, and add it back to the end
		//orig.add(xplNum);
		
//		System.out.println("Original List modified to : " + orig);
	}
	
	
	public static void main(String[] args) {
		ExpelledNumbers eN = new ExpelledNumbers();
		eN.solvePuzzle(10000);
	}

}












/*
int[] fetchHelper(int[] orig, int pos, int span){
	 return new int [] {orig[pos-span], orig[pos+span]};			
}


int[] fetchAfterExplusion(int[] orig, int lBound, int rBound, int xplPos){
	int[] res = new int[rBound];
	

	if(xplPos == lBound) {
		res[0] = -1;
		res[1] = orig[rBound];
		return res;
	}
		
	
	int span = xplPos - lBound;
	int ptr = 0;

	
	while(span>1) {
		int[] x = fetchHelper(orig, xplPos, span);
		res[ptr] = x[0];
		res[++ptr] = x[1];
		
		System.out.println(Arrays.toString(x));
		ptr++;
		
		span--;
	}
	
	return res; 
}

private void findSeries(int max) {
	int[] a = fillArray(max);
	List<Integer> expNumbers = new ArrayList<>();
	int xplPos = 0; 
	//a[0] = -1;
	
	for(int i=1;i<a.length; i++) {
		xplPos++;
		
		
		expNumbers.add(a[xplPos]);
		
		int left = 1; //array is zero based. Exclude pos0
		int right = xplPos+i;
		
		
		int[] rem = fetchAfterExplusion(a, left,right,xplPos);
		
		System.out.println("After running iteration : " + i + " remainder array is : " + Arrays.toString(rem));
		
	}
}

private void replaceValues(int[] orig,int[] replace) {
	for(int i=0;i<rem.length;i++) {
		orig[i]=
	}
}

private int[] fillArray(int max){
	int[] x = new int[max+1];
	x[0]=-1;
	for(int i=1; i<=max;i++){
		x[i] = i;
	}
	//System.out.println(Arrays.toString(x));
	
	return x; 
}

*/
