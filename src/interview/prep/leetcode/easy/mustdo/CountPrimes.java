package interview.prep.leetcode.easy.mustdo;

import java.util.Arrays;

public class CountPrimes {
    //Using Sieve of Eratosthenes method.
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for(int i=2; i*i<=n;i++){
            if(primes[i]){
                //mark all multiples of i to false;
                for(int j=i; j*i<n;j++){
                    primes[j*i] = false;
                }
            }
        }
        int res=0;
        for(int i=2; i<n; i++){
            if(primes[i])
                res++;
        }

        return res;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        cp.countPrimes(8);
    }


    //T - O(N), S-O(1)
    private boolean isNumPrime(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i ==0)
                return false;
        }
        return true;
    }

    //T- O(N2), S O(1)
    public int _countPrimes(int n) {
        if(n<=0)
            return 0;
        int cnt = 0;

        for(int i=2; i<n; i++){
            boolean prime = isNumPrime(i);
            if(prime){
                // System.out.println("Is "+ i+ " prime ? " + prime);
                cnt++;
            }
        }
        return cnt;
    }
}
/*
7
10
0
1
2
17
2000
5000000
*/