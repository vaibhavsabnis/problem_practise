package interview.prep;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/*
 * 2. Add Two Numbers
Medium

8557

2167

Add to List

Share
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1.val == 0 && l1.next == null)
			return l2;
		if (l2.val == 0 && l2.next == null)
			return l1;

		int carry = 0;
		boolean isL1Over = (l1 == null);
		boolean isL2Over = (l2 == null);
		ListNode ansLst = new ListNode();
		ListNode ansHead = ansLst;
		int L1Val = 0;
		int L2Val = 0;

		while (!isL1Over || !isL2Over) {
			if (l1 == null)
				isL1Over = true;
			if (l2 == null)
				isL2Over = true;

			if (isL1Over && isL2Over && carry == 0)
				break;
			L1Val = isL1Over ? 0 : l1.val;
			L2Val = isL2Over ? 0 : l2.val;

			int ans = L1Val + L2Val + carry;
			if (ans >= 10) {
				carry = ans / 10;
				ans = ans % 10;
			} else {
				carry = 0;
			}
			ansLst.val = ans;
			if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || carry != 0) {
				ansLst.next = new ListNode();
				ansLst = ansLst.next;
			}
			l1 = isL1Over ? null : l1.next;
			l2 = isL2Over ? null : l2.next;
		}
		return ansHead;
	}

	public String restoreString(String s, int[] indices) {
		char[] c = new char[s.length()];
		for (int i = 0; i < indices.length; i++) {
			int position = indices[i];
			char temp = s.charAt(i);
			c[position] = temp;
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : c) {
			sb.append(ch);
		}
		return sb.toString();
	}

	/**
	 * Definition for singly-linked list.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return val + " ->" + next;
		}
	}

	public ListNode _addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1.val == 0 && l1.next == null)
			return l2;
		if (l2.val == 0 && l2.next == null)
			return l1;

//		Stack<Integer> stk1 = populateStack(l1);
//		Stack<Integer> stk2 = populateStack(l2);
//		
//		int num1 = fetchNumRepresentation(stk1);
//		int num2 = fetchNumRepresentation(stk2);

//		int res = num1 + num2;
		long num1 = fetchInt(l1);
		long num2 = fetchInt(l2);

		long res = num1 + num2;

		return getReverseListNodeRep(res + "");
	}

	public long fetchInt(ListNode nums) {
		StringBuilder sb = new StringBuilder();
		while (nums != null) {
			sb.append(nums.val);
			nums = nums.next;
		}
		return Long.parseLong(sb.toString());
	}

	public ListNode getReverseListNodeRep(String num) {
//		if (num <10) {
//			return new ListNode((int)num);
//		}
		char[] arr = num.toCharArray();// Long.toString(num).toCharArray();

		ListNode head = new ListNode(Character.getNumericValue(arr[arr.length - 1]));
		ListNode curr = head;
		for (int i = arr.length - 2; i >= 0; i--) {
			ListNode temp = new ListNode(Character.getNumericValue(arr[i]));
			curr.next = temp;
			curr = temp;
		}
		return head;
	}

	public Stack<Integer> populateStack(ListNode nums) {
		Stack<Integer> res = new Stack<>();

		while (nums != null) {
			res.push(nums.val);
			nums = nums.next;
		}
		return res;
	}

	public Integer fetchNumRepresentation(Stack<Integer> stk) {
		if (stk.isEmpty())
			return 0;
		int res = 0;

		while (!stk.isEmpty()) {
			int mul = (int) Math.pow(10, stk.size());
			res += stk.pop() * mul;
		}
		return res / 10;
	}

	public static void _main(String[] arg) {
		AddTwoNumbers atn = new AddTwoNumbers();
//		ListNode l1 = atn.getReverseListNodeRep("9");//(342);//
//		ListNode l2 = atn.getReverseListNodeRep("99999999991");//(465);
////		
////		[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
////				[5,6,4]
//						
//		ListNode ans = atn.addTwoNumbers(l1, l2);

		System.out.println(atn.restoreString("abc", new int[] { 0, 1, 2 }));
//		System.out.println(ans);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int countPairs(TreeNode root, int distance) {
		if(distance <=1 || root.left==null && root.right==null)
			return 1; 
		
		int goodPairs =0;
		List<TreeNode> leaves = new LinkedList<>();
		
		populatePathToLeaves(root,leaves);
		
		for(int i=0; i<leaves.size(); i++) {
			TreeNode currLeaf = leaves.get(i);
//			goodPairs += findGoodPairs(currLeaf, leaves,distance);
		}
		return goodPairs;
	}
	
	private void populatePathToLeaves(TreeNode node, List<TreeNode> leaves) {
		if(node==null)
			return;
		if(node.left ==null && node.right ==null) {//leaf node
			leaves.add(node);
		}
		if(node.left!=null) {
			
		}
	}
	
	private void dfs() {
		
	}
	
	
    public int getLengthOfOptimalCompression(String s, int k) {
        if(s==null) return 0; 
        if (s.length()==1 ) return 1;
        
        Map<Character,Integer> map = new TreeMap<>();
        for(char c: s.toCharArray()) {
        	map.put(c,map.getOrDefault(c, 0)+1);
        }
        Iterator<Character> iter = map.keySet().iterator();
        
        if(k==0)
        	return map.keySet().size();
        
        int optLen = 0; 
        while(iter.hasNext()) {
        	if(map.get(iter.next()) == 1)
        		optLen +=1;
        	else
        		optLen +=2;
        }
        
        return optLen;
    }
    
    
    public int addDigits(int num) {
        if(num<10)
            return num;         
        int res = helper(num);
        System.out.println(res);
        return res;
    }
    
    private int helper(int num){
        if(num<10)
            return num; 
        
        char[] cNum = (num+"").toCharArray();
        int temp = 0; 
        for(char c: cNum)
        	temp += Character.getNumericValue(c);
        
        return helper(temp);
    }
	
    public static void main(String args[]) {
    	AddTwoNumbers atn = new AddTwoNumbers(); 
    	atn.addDigits(38);
    }
}
