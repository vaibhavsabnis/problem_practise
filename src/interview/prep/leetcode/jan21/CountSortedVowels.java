package interview.prep.leetcode.jan21;

import java.util.ArrayList;
import java.util.List;

public class CountSortedVowels {

    public static void main(String[] args) {
        CountSortedVowels cs = new CountSortedVowels();
        List<String> res = new ArrayList<>();
        String baseStr = "aeiou";
        String toPermute = cs.formString(1,baseStr);
        cs.permute(toPermute, 0, toPermute.length()-1, res);

        System.out.println("Total Valid Permutations of string: '" +toPermute +"' are: "+ res.size());
        res.forEach(i ->  System.out.print(i+", "));
    }

    private String formString(int n, String baseStr){
        if (n==0) return "";
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n; i++)
            sb.append(baseStr);

        return sb.toString();
    }

//    Map<Character,Integer> relativePos = new HashMap<>();
//
//    private void populateRelativePosition(String str){
//        int i=0;
//        for (char c: str.toCharArray())
//            relativePos.put(c,i++);
//    }
    private boolean isPosValid(String str, int currPos){
        if(currPos ==0)
            return true;

        char prior = str.charAt(currPos-1);
        char curr = str.charAt(currPos);
        return curr>=prior;

//        if(curr >= prior)
//            return true;
//        else
//            return false;
    }
    //Total Permutations: 6
    //abc, acb, bac, bca, cba, cab,


    public void permute(String s, int left, int right, List<String> answer){

        if(left == right)
            answer.add(s);
        else{
            for(int i=left; i<=right; i++){
                s = swap(s,left,i);

                permute(s,left+1,right,answer);
//                s = swap(s,i,left);
            }
        }
    }

    private String swap(String s, int a, int b){
        if(a==b || a>=s.length() || b >= s.length())
            return s;

        char[] ch = s.toCharArray();

        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;

        return String.valueOf(ch);
    }
}
