package interview.prep.hired.com;

public class FindTreeHeight {
	// Java implementation of above approach

	void fillDepth(int tree[], int pos, int depth[]) { 
		  
        // If depth[i] is already filled 
        if (depth[pos] != 0) { 
            return; 
        } 
  
        // If node at index i is root 
        if (tree[pos] == -1) { 
            depth[pos] = 1; 
            return; 
        } 
  
        // If depth of tree is not evaluated before, then evaluate 
        // depth of tree first 
        if (depth[tree[pos]] == 0) { 
            fillDepth(tree, tree[pos], depth); 
        } 
  
        // Depth of this node is depth of tree plus 1 
        depth[pos] = depth[tree[pos]] + 1; 
    } 
  
    // This function returns height of binary tree represented by 
    // tree array 
    int findHeight(int tree[], int n) { 
          
        // Create an array to store depth of all nodes/ and 
        // initialize depth of every node as 0 (an invalid 
        // value). Depth of root is 1 
        int depth[] = new int[n]; 
        for (int i = 0; i < n; i++) { 
            depth[i] = 0; 
        } 
  
        // fill depth of all nodes 
        for (int i = 0; i < n; i++) { 
            fillDepth(tree, i, depth); 
        } 
  
        // The height of binary tree is maximum of all depths. 
        // Find the maximum value in depth[] and assign it to ht. 
        int ht = depth[0]; 
        for (int i = 1; i < n; i++) { 
            if (ht < depth[i]) { 
                ht = depth[i]; 
            } 
        } 
        return ht; 
    } 
	
		public static long solution(long[] tree) {
			// Type your solution here
			if (tree == null || tree.length == 0)
				return 0;
			if (tree.length == 1)
				return 1;

			long root = tree[0];

			int[] depth = new int[tree.length];
			depth[0] = 1;
			for (int i = 0; i < tree.length; i++) {
				fillDepth(tree, i, depth);
			}
			int ht = 0;
			for (int i : depth) {
				ht = Math.max(ht, i);
			}

			return ht;
		}

		public static void fillDepth(long[] tree, int pos, int depth[]) {
			// If depth already calculated
			if (depth[pos] != 0) {
				return;
			}
			// If this is root node or empty, return 1
			if (tree[pos] == -1) {
				depth[pos] = 1;
				return;
			}
			// eval depth of my parent first
			if (depth[(int) tree[pos]] == 0) {
				fillDepth(tree, (int) tree[pos], depth);
			}

			// Node for me is my parent + 1
			depth[pos] = depth[(int) tree[pos]] + 1;
		}

	public static void main(String[] args) { 
		  
//      BinaryTree tree = new BinaryTree(); 

      // int tree[] = {1, 5, 5, 2, 2, -1, 3}; 
      int tree[] = new int[]{-1, 0, 0, 1, 1, 3, 5}; 

      int n = tree.length; 
//      System.out.println("Height is  " + tree.findHeight(tree, n)); 
  }

}
