package interview.prep;


public class FooPrinter {
	private FooPrinter bar = new FooPrinter(); //will cause Stack overflow
	
	public void print() {
		System.out.println("Foo");
	}
	
	public FooPrinter() {
		this.bar.print();
	}
	public static void main(String a[]) {
		new FooPrinter();
	}

}
