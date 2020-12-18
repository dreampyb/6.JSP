package javaStudy;

public class Test {

	public static void main(String[] args) {
		Cal a1;
		a1 = new A1();
		System.out.println(a1.result(4, 5));
		a1.result_print();
		//a1.addMethod1();

		a1 = new B1();
		System.out.println(a1.result(4, 5));
		a1.result_print();
		//b1.addMethod2();
		
	}

}
