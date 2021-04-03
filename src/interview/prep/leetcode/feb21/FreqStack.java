package interview.prep.leetcode.feb21;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
/*
Implement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

push(int x), which pushes an integer x onto the stack.
pop(), which removes and returns the most frequent element in the stack.
If there is a tie for most frequent element,
the element closest to the top of the stack is removed and returned.

 */
class FreqStack {
    class Point{
        int val;
        int freq;
        int pos;

        Point(int val, int pos){
            this.val = val;
            this.freq++;
            this.pos = pos;
        }
    }
    PriorityQueue<Point> q;
    AtomicInteger pos= new AtomicInteger(1);
    Map<Integer,Integer> valFreqMap = new HashMap<>();

    public FreqStack() {
        initialize();
    }
    private void initialize(){
        q = new PriorityQueue<>((a, b)->{
            if(a.freq < b.freq){
                return -1;
            }else if(a.freq > b.freq){
                return 1;
            }
            else {//same freq
                if(a.pos < b.pos)
                    return -1;
                else
                    return 1;
            }
        });
    }

    public void push(int x) {
        valFreqMap.put(x,valFreqMap.getOrDefault(x,0)+1);

    }

    public int pop() {
return -1;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
