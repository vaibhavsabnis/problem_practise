package interview.prep.leetcode.june20;

/*
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary {"JFK", "LGA"} has a smaller lexical order than {"JFK", "LGB"}.
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}]
Output: {"JFK", "MUC", "LHR", "SFO", "SJC"}
Example 2:

Input: [{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}]
Output: {"JFK","ATL","JFK","SFO","ATL","SFO"}
Explanation: Another possible reconstruction is {"JFK","SFO","ATL","JFK","ATL","SFO"}.
             But it is larger in lexical order.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue; 

public class ReconstructItinerary {

	LinkedList<String> itinerary = new LinkedList<>(); 
	Map<String,Queue<String>> mapFromTo = new HashMap<>();
	
	public List<String> findItinerary(List<List<String>> tickets) {
		
		//Sanitize
		if(tickets.size() == 1)
			return tickets.get(0); 
		
		//Method variables
				
		//Main Logic
		//1. Create Map of from and to destinations - sorted by location
		
		for(List<String> eachTrip: tickets) {
			String start = eachTrip.get(0);
			String end = eachTrip.get(1); 
			
			Queue<String> endList = mapFromTo.get(start);
			
			if (endList ==null) {
				endList = new PriorityQueue<String>();
			}			
			endList.add(end); 			
			mapFromTo.put(start, endList); 
		}
		
		/*
		//Iterate through each starting with JFK.
		String from = "JFK";

		String finalDestination = "";
		while (from!=null) {			 
			Queue<String> nextDest = mapFromTo.get(from);
			if(!nextDest.isEmpty()) {
				String nextArrival = nextDest.poll();
				
				if(mapFromTo.get(nextArrival) ==null) {
					finalDestination = nextArrival;
					continue;
				}

				itinerary.add(from);
				from = nextArrival;
			}else {//This is the last destination
				itinerary.add(from);
				from = null; 
			}
		}
		if(finalDestination !="")
			itinerary.add(finalDestination);
		*/
		
		dfs("JFK");
		//Return results
		return itinerary;

	}
	//Expected : ["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK","AXA","EZE","TIA","AUA","AXA","TIA","ADL","EZE","HBA"]
	
	void dfs(String from){
		Queue<String> arrivals = mapFromTo.get(from);
		while(arrivals!=null && !arrivals.isEmpty()) {
			dfs(arrivals.poll());
		}
		itinerary.addFirst(from);
	}

	public static void main(String[] args) {
		ReconstructItinerary ri = new ReconstructItinerary();
//		String[][] itinArray = new String[][] {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}; 
//		String[][] itinArray = new String[][] {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//		String[][] itinArray = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}}; 
		String[][] itinArray = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
		List<List<String>> itinList = ri.convertArrToLst(itinArray);
		long startTime = System.currentTimeMillis(); 
		System.out.println(ri.findItinerary(itinList));
		System.out.println("It took :" + (System.currentTimeMillis()-startTime) +" msec");		
	}
	
	
	private List<List<String>> convertArrToLst(String[][] itinArray){
		List<List<String>> itinList = new ArrayList<>();
		
		for(String[] fromTo: itinArray) {
			List<String> temp = new ArrayList<>(); 
			temp.addAll(Arrays.asList(fromTo));
			
			itinList.add(temp); 
		}
		
		return itinList;
	}

}
