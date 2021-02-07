package interview.prep.leetcode.feb21;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ClosestCharacter {

    public static void main(String[] args) {
        ClosestCharacter obj = new ClosestCharacter();
//        obj.shortestToChar("loveleetcode",'e');
        obj.shortestToChar("cizokxcijwbyspcfcqws",'c');
    }

    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        TreeSet<Integer> cPos = new TreeSet<>();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(ch != c)
                continue;
            else
                cPos.add(i);
        }
        System.out.println("Position of char :"+ c + " in incoming string: " + cPos);


        for(int i=0; i<s.length(); i++){

            Character ch = s.charAt(i);
            if(ch.charValue() == c)
                res[i] = 0;
            else{
                int hwm = cPos.ceiling(i) == null ? cPos.last(): cPos.ceiling(i);
                int lwm = cPos.floor(i) == null ? cPos.first(): cPos.floor(i);
                res[i] = Math.min(Math.abs(i-lwm) , Math.abs(hwm-i));
            }
            // System.out.println("Closest position for " + ch + "("+i+") is: " + res[i]);
        }

        return res;
    }

        public int[] _shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
//        Map<Character, List<Integer>> map = new HashMap<>();

        List<Integer> cPos = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(ch != c)
                continue;
            else
                // List<Integer> temp = map.getOrDefault(ch,new ArrayList<>());
                cPos.add(i);

            // map.put(ch,temp);
        }
        System.out.println("Position of char :"+ c + " in incoming string: " + cPos);

        for(int i=0; i<s.length(); i++){

            Character ch = s.charAt(i);
            if(ch.charValue() == c)
                res[i] = 0;
            else{
                res[i] = findClosest(i,cPos);
            }
            System.out.println("Closest position for " + ch + "("+i+") is: " + res[i]);
        }

        return res;
    }

    private int findClosest(int target, List<Integer> c){
        int low =0;
        int hi = c.size()-1;
        int lwm = low;
        int hwm = hi;

        int mid = 0;
        while(low < hi){
            lwm = low;
            hwm = hi;

            mid = low + (hi-low)/2;
            if(c.get(mid) == target)
                return 0;
            if(c.get(mid) < target)
                low = mid+1;
            else
                hi = mid-1;
        }

        return Math.min(Math.abs(c.get(hwm)-target),Math.abs(c.get(lwm)-target));
    }
}
