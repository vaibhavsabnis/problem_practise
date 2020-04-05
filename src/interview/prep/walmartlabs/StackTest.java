package interview.prep.walmartlabs;

import java.util.ArrayList;
import java.util.List;
import lombok.Data; 

/**
 * 
 * Asked by Walmart on Dec 2019 
 * 
 * @author vaibhav
 *
 */
@Data
class MyIntegerStack {
	private List<Integer> myList;
	private int lastEleIndex = -1;

	MyIntegerStack() {
		myList = new ArrayList<Integer>();
	}

	// push
	public void push(int i) {
		myList.add(i);
		lastEleIndex++;
	}

	// peek
	public int peek() {
		return myList.get(lastEleIndex);
	}

	// isEmpty
	public boolean isEmpty() {
		return (lastEleIndex == 0);
	}

	// pop
	public int pop() {
		return myList.get(lastEleIndex--);
	}

	public void printContents() {
		System.out.println("My Integer Stack elements Size: " + myList.size());
		System.out.println("Printing Contents: >>>>");
		myList.forEach(System.out::println);
		System.out.println("<<<<");
	}

}

public class StackTest {
	public static void main(String args[]) {
		MyIntegerStack ms = new MyIntegerStack();
		pushToStack(ms);
		ms.printContents();

		System.out.println(ms.peek());
	}

	static void pushToStack(MyIntegerStack ms) {
		ms.push(5);
		ms.push(3);
		ms.push(4);
		ms.push(7);
		ms.push(2);
		ms.push(1);
	}
}