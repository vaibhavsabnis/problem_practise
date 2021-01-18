package interview.prep.leetcode.easy.mustdo;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int n = 8;
        System.out.println("Recursively: " + f.fibRecurse(n));
        System.out.println("Iteratively: " + f.fibIterative(n));
    }
    private int fibRecurse(int n){
        if(n ==0 ) return 0;
        if(n==1) return 1;
        int temp = fibRecurse(n-1) + fibRecurse(n-2);
        System.out.print(temp +",");
        return temp;
    }
    private int fibIterative(int n){

        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(Arrays.toString(arr));
        return arr[n-1];
    }
}
