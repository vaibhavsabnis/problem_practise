package interview.prep.leetcode.easy.mustdo;

import java.util.PriorityQueue;
import java.util.Stack;

/*
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {


    Stack<Integer> stack;
    int minEle;
    PriorityQueue<Integer> minHeap;

    public MinStack() {
        stack = new Stack<>();
        minHeap = new PriorityQueue<>();
        minEle = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        minHeap.offer(x);
        minEle = Math.min(minEle, x);
    }

    public void pop() {
        /* FIXME - to maintain constant time - remove on PQ won't work ? */
        if ((stack.peek() == minEle)) {
            minHeap.poll();
        } else {
            minHeap.remove(stack.peek());
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minEle;
    }
}