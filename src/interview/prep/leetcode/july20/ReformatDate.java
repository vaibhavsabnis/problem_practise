package interview.prep.leetcode.july20;

import java.util.HashMap;
import java.util.Map;
/*
 * Given a date string in the form Day Month Year, where:

Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:

YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.
 */
public class ReformatDate {

	public static void main(String args[]) {
		ReformatDate rd = new ReformatDate();
		
		System.out.println(rd.reformatDate("1st Oct 2052"));
		System.out.println(rd.reformatDate("31st Dec 2042"));
		
//		pwrSet.rangeSum(new int[] {1,2,3,4}, 4, 1, 5);
//		pwrSet.minDifference(new int[] {5,3,2,4});
	}

	//"20th Oct 2052"
	//"1st Oct 2052"
	public String reformatDate(String date) {
		java.text.SimpleDateFormat sd = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		String[] month = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		Map<String,Integer> mthMap = new HashMap<>();
		int cnt=-1; 
		for(String m: month) {
			mthMap.put(m,++cnt);
		}
		
		int lastIdx = date.length();
		
		String year = date.substring(lastIdx-4, lastIdx);
		String mth = date.substring(lastIdx-8, lastIdx-5);
		String dt = date.substring(0,lastIdx-11);
		
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.set(Integer.parseInt(year), mthMap.get(mth).intValue(), Integer.parseInt(dt));
		
		return sd.format(c.getTime());
	}
}
