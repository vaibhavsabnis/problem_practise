package interview.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import lombok.Data;

@Data
class Node{
	char value;
	Node leftChild;
	Node rightChild;
	public Node(char character){
		value = character;
	}
	public List<Node> getChildNodes(){
		List<Node> adj= new ArrayList<>();
		adj.add(leftChild);
		adj.add(rightChild);
		return adj;		
	}
	
	@Override
	public String toString() {
		return "value: " + value;
	}
}

public class TreeSearchAlgo {	
	
	/*
	 * Using Stack - Iteration
	 */
	static void performDFSUsingIteration(Node root){
		
		Stack<Node> stack = new Stack<>(); //DataStructure enforces LIFO (and hence DFS) 
		Set<Node> visited = new HashSet<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			Node curr = stack.pop();
			
			if(!visited.contains(curr)) {
				visited.add(curr);
				doWorkonNode(curr); //>>> Actual work
			}
			
			for(Node child:curr.getChildNodes()) {				
				if(child!=null && !visited.contains(child)) {					
					stack.push(child);
				}
			}
		}
	}
	
	/*
	 * Using Queue - Iteration
	 */
	static void performBFSUsingIteration(Node root) {
		
		Queue<Node> queue = new PriorityQueue<>();
		Set<Node> visited = new HashSet<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node curr = queue.poll(); //Get the item
			
			if(!visited.contains(curr)) {
				visited.add(curr);
				doWorkonNode(curr); //Actual Work;
			}
			
			for(Node child: curr.getChildNodes()) {
				if(child!=null && !visited.contains(child)) {
					queue.add(child);
				}
			}
		}		
	}
	
	static void performDFSUsingRecursion(Node root){
		Set<Node> visted = new HashSet<>();		
		dfs(root,visted);
	}
	
	/*
	 * The recursive function
	 */
	static void dfs(Node node, Set<Node> visited){
		
		if(visited.contains(node)||node==null)
			return;
		
		visited.add(node);
		doWorkonNode(node);
		
		for(Node child: node.getChildNodes()) {
			if(!visited.contains(child))
				dfs(child,visited);
		}
	}


	/*
	 * Worker function - currently only prints the node
	 */
	public static void doWorkonNode(Node node) {
		System.out.println(node);
	}

	public static void main(String a[]) {
		
		Node root = buildTree();
		System.out.println("Performing DFS using iteration");
		performDFSUsingRecursion(root);
		
		System.out.println("Performing DFS using Stack - Iteration");
		performDFSUsingIteration(root);
		System.out.println("Performing BFS using Queue - Iteration");
		performBFSUsingIteration(root);
		
	}
	
	/*
	 * 					    A
	 * 				   _ _ _|_ _ _ 
	 * 				  B        	  C
	 * 			   _ _|_ 	    _ _|_ _
	 * 			  D		E      F	   G
	 * 		   _ _|         _ _|		|_ _
	 * 		  H		       J				L
	 * 				    _ _|
	 * 			       K
	 */
	static Node buildTree(){
		
		Node root = new Node('A');
		Node b = 	new Node('B');
		Node c = 	new Node('C');
		Node d= 	new Node('D');
		Node e= 	new Node('E');
		Node f= 	new Node('F');
		Node g= 	new Node('G');
		Node h= 	new Node('H');
		Node i = 	new Node('I');
		Node j= 	new Node('J');
		Node k= 	new Node('K');
		Node l= 	new Node('L');
		
		root.leftChild = b;
		root.rightChild = c;
		
		b.leftChild = d;
		b.rightChild = e;
		
		d.leftChild = h;
		d.rightChild = i;
		
		c.leftChild =f;
		c.rightChild = g;
		
		f.leftChild = j;
		j.leftChild = k;
		
		g.rightChild = l;
		
		return root;
	}
}
