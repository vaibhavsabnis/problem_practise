package interview.prep.leetcode.feb21;

import lombok.val;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null || popped ==null ||pushed.length != popped.length)
            return false;
        Stack<Integer> myStk = new Stack<>();
        int pop = 0;

        for(int push: pushed){
            myStk.push(push);
            while(!myStk.isEmpty() && myStk.peek() == popped[pop]){
                myStk.pop();
                pop++;
            }
        }

        return myStk.isEmpty() && pop >= popped.length-1;
    }
    public boolean _validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null || popped ==null ||pushed.length != popped.length)
            return false;

        Stack<Integer> myStk = new Stack<>();
        int popCtr = 0;
        int[] myPopSeq = new int[popped.length];
        for(int i=0; i<pushed.length; i++){ //TC: O(N)
            int currPop = popped[popCtr];
            while(i< pushed.length && currPop != pushed[i]){
                myStk.push(pushed[i]);
                i++;
            }
//            if(i >= pushed.length && popCtr != popped.length)// really an optimization
//                return false;

            myStk.push(currPop);
            myPopSeq[popCtr++]   = myStk.pop();
        }

//        System.out.println("My myPopSeq state after processing all pushed : " + myPopSeq);

        while(!myStk.isEmpty()&& popCtr < popped.length){ //TC: O(N)
            myPopSeq[popCtr] = myStk.pop();
            popCtr++;
        }

//        System.out.println("My myPopSeq state at end: " + myPopSeq);

        for(int i=0; i<myPopSeq.length; i++){//TC:O(N)
            if(popped[i] != myPopSeq[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidateStackSequences vs = new ValidateStackSequences();
//        int[] pushed = {1,2,3,4,5};
//        int[] popped = {4,5,3,2,1};
//        int[] pushed = {1,2,3,4,5};
//        int[] popped = {4,3,5,2,1};
        int[] pushed = {2,1,0};
        int[] popped = {1,2,0};

        System.out.println(vs.validateStackSequences(pushed,popped));
    }
}
