package javaStudy;

public class Main {

	public static void main(String[] args) {
		A1 a1= new A1();
		System.out.println(a1.result(4, 5));
		a1.result_print();
		a1.addMethod1();
		
		B1 b1  = new B1();
		System.out.println(b1.result(4, 5));
		//a1.result_print();
		b1.addMethod2();

	}

}
