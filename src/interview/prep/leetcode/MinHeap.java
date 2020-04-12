package interview.prep.leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

/*
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */

class MinStack1{
	/** initialize your data structure here. */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	Stack<Integer> stack = new Stack<>();
    
    public MinStack1() {
    }
    
    public void push(int x) {
    	minHeap.add(x);
    	stack.push(x);
    }
    
    public void pop() {
    	minHeap.remove(top());
    	stack.pop();
    }
    
    public int top() {
        if(!stack.empty())
        	return stack.peek();
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
    	if(!minHeap.isEmpty())
    		return minHeap.peek();
    	return Integer.MIN_VALUE;
    }
}

class MinStack {

	Stack<Integer> stack = new Stack<Integer>();
	int minEle = Integer.MAX_VALUE;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	
	public MinStack() {
        
    }
    
    public void push(int x) {
    	stack.push(x);
    	minHeap.add(x);
    	
    	minEle = Math.min(x, minEle);
        
    }
    
    public void pop() {
        int p = stack.pop();
        if(minEle == p) {
        	minHeap.poll();
        	
        	minEle = (!minHeap.isEmpty()) ? minHeap.peek():Integer.MAX_VALUE ;
        }
        else {
            minHeap.remove(p);
        }
    }
    
    public int top() {
    	System.out.println(stack.peek());
        return stack.peek();
    }
    
    public int getMin() {
    	System.out.println(minEle);
        return minEle;
    }
}

public class MinHeap {

	public static void main(String args[]) {
		MinStack minStack = new MinStack();
		minStack.push(2147483646);
		minStack.push(2147483646);
		minStack.push(2147483647);		
		minStack.top();
		minStack.pop();		
		minStack.getMin();
		minStack.pop();
		minStack.getMin();
		minStack.pop();
		minStack.push(2147483647);
		minStack.top();
		minStack.getMin();
		minStack.push(-2147483648);
		minStack.top();
		minStack.getMin();
		minStack.pop();
		minStack.getMin();
		
		

//		minStack.push(-2);
//		minStack.push(0);		
//		minStack.push(-1);
//		
//		System.out.println(minStack.getMin());
//		System.out.println(minStack.top());
//		minStack.pop();
//		System.out.println(minStack.getMin());
		

		
//		minStack.push(-2);
//		minStack.push(0);
//		minStack.push(-3);
//		System.out.println(minStack.getMin());   //--> Returns -3.
//		minStack.pop();
//		System.out.println(minStack.top());      //--> Returns 0.
//		System.out.println(minStack.getMin());   //--> Returns -2.
		
		
//		minStack.push(-2);
//		minStack.push(0);
//		minStack.push(-1);
//		System.out.println(minStack.getMin());   //--> Returns -2.
//		System.out.println(minStack.top());   //--> Returns -1.
//		minStack.pop();
//		System.out.println(minStack.getMin());   //--> Returns -2
		
		
	}
}

/*
 * 

["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]


Input:
["MinStack","push","push","push","getMin","top","pop","getMin"]
[[],[-2],[0],[-1],[],[],[],[]]
Output:
[null,null,null,null,-2,-1,null,-1]
Expected:
[null,null,null,null,-2,-1,null,-2]
 
 Input:
["MinStack","push","push","push","getMin","top","pop","getMin"]
[[],[-2],[0],[-1],[],[],[],[]]
Output:
[null,null,null,null,-2,-1,null,-1]
Expected:
[null,null,null,null,-2,-1,null,-2]
*/


	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
