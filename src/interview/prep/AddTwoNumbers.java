package interview.prep;

import java.util.Stack;

public class AddTwoNumbers {
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
			return val +" ->" + next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1.val == 0 && l1.next ==null)
			return l2;
		if (l2.val == 0 && l2.next ==null)
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
		
		return getReverseListNodeRep(res);
	}
	
	public long fetchInt(ListNode nums) {
		StringBuilder sb = new StringBuilder();
		while (nums != null) {
			sb.append(nums.val);
			nums = nums.next;
		}
		return Long.parseLong(sb.toString());
	}
	public ListNode getReverseListNodeRep(long num) {
		if (num <10) {
			return new ListNode((int)num);
		}
		char[] arr = Long.toString(num).toCharArray();
		
		ListNode head = new ListNode(Character.getNumericValue(arr[arr.length-1]));
		ListNode curr = head; 
		for(int i=arr.length-2; i>=0; i--) {
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
		if(stk.isEmpty())
			return 0;
		int res = 0;
		
		while(!stk.isEmpty()) {
			int mul = (int)Math.pow(10,stk.size());
			res += stk.pop()*mul;
		}
		return res/10;
	}
	
	
	public static void main(String [] arg) {
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode l1 = atn.getReverseListNodeRep(9);
		ListNode l2 = atn.getReverseListNodeRep(1999999999);
//		
//		[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
//				[5,6,4]
						
		ListNode ans = atn.addTwoNumbers(l1, l2);
	
		System.out.println(ans);
	}
}
