package interview.prep.dec20;

import java.util.ArrayList;
import java.util.List;

public class KthFactorOfN {

    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>(); 
        
        for(int i=1; i<=n/2; i++){
            if(factors.size() >=k)
                break; 
            
            if(n%i ==0)
                factors.add(i); 
        }
        factors.add(n); 
        // System.out.println("Factors:" + factors); 
        if(factors.size()>=k)
            return factors.get(k-1);
        else 
            return -1; 
    }
}
/*
12
3
7
2
4
4
1
1
1000
3
1000
8
*/
