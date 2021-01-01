package interview.prep.leetcode.dec20;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    public String toString() {
    	return this.val+""; 
    }
};
public class NextRightPointerII {

	   public Node connect(Node root) {
	        //sanitize
	        //put in queue
	        //do work
	        //add children
	        
	        if(root ==null || (root.left ==null && root.right ==null))
	            return root; 
	        
	        LinkedList<Node> q = new LinkedList<>(); 
	        q.add(root); 
	        while(!q.isEmpty()){
	            System.out.print("\n Enter Q: with size: "+ q.size() +" -->" ); q.forEach(i -> System.out.print(i.val + " ")); 
	            
	            int qSize = q.size(); 
	            
	            for(int i=0; i<qSize-1;i++){
	                Node temp = q.poll(); 
	                temp.next = q.peek(); 
	                addChildren(temp, q); 
	            }
	            //process last of this run;
	            Node last = q.poll(); 
	            last.next = null; 
	            //add children
	            addChildren(last, q); 
	            
	            System.out.print("\n Exit Q: size: "+ q.size() +" -->" ); q.forEach(i -> System.out.print(i.val + " "));
	        }
	        return root; 
	    }
	    
	    private void addChildren(Node n, Queue<Node> q){
	        if(n ==null )
	            return; 
	        if(n.left != null) q.add(n.left); 
	        if(n.right!= null) q.add(n.right); 
	    }
	    
	    public static void main(String args[]) {
	    	Node _4 = new Node(4); 
	    	Node _5 = new Node(5);
	    	Node _7 = new Node(7);
	    	Node _2 = new Node(2,_4,_5,null);
	    	Node _3 = new Node(3,null,_7,null);
	    	Node _1 = new Node(1, _2,_3,null); 

	    	NextRightPointerII nrp = new NextRightPointerII(); 
	    	nrp.connect(_1);
	    }
}