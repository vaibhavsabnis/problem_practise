package interview.prep.leetcode.sep20;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/*
 * Compare Version Numbers

Solution
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.

The . character does not represent a decimal point and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.

 

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
Example 4:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both �01� and �001" represent the same number �1�
Example 5:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 

Note:

Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
Version strings do not start or end with dots, and they will not be two consecutive dots.
 */
public class VersionCompare {

	public int compareVersion(String version1, String version2) {
        int[] arr1 = getArrRepUsingSplit(version1); 
        int[] arr2 = getArrRepUsingSplit(version2); 
        int ans = 0; 
        int len = arr1.length < arr2.length ?arr2.length: arr1.length; 
        if(arr1.length !=len)
            arr1 = Arrays.copyOf(arr1,len); 
        if(arr2.length !=len)
            arr2 = Arrays.copyOf(arr2,len); 
        
        
        for(int i=0; i<len; i++){
            if(arr1[i] == arr2[i])
                continue;
            if(arr1[i]>arr2[i])
                return 1; 
            if(arr1[i]<arr2[i])
                return -1; 
        }
        
        return ans;
    }
    
    private int[] getArrRepUsingTokens(String version){
        if(version ==null) return new int[]{}; 
        StringTokenizer st = new StringTokenizer(version,"."); 
        
        int[] res = new int[st.countTokens()]; 
        int i=0; 
        while(st.hasMoreTokens()){
            res[i++] = Integer.parseInt(st.nextToken()); 
        }
        return res; 
    }
    
    private int[] getArrRepUsingSplit(String version){
        if(version ==null) return new int[]{}; 
        return Arrays.stream(version.split(Pattern.quote("."))).mapToInt(Integer::parseInt).toArray();         
    }
    
    public static void main(String ar[]) {
    	VersionCompare vc = new VersionCompare(); 
    	vc.compareVersion("1.0", "1.0.1");
    }
}
/*
"0.1"
"1.1"
"7.5.2.4"
"7.5.3"
"1.01"
"1.001"
"1.0"
"1.0.0"
"1.0.1"
"1"
*/