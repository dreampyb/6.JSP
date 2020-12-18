package javaStudy;

public class A1 implements Cal {

	@Override
	public int result(int a, int b) {
		//더하기 수행
		return a+b;
	}

	@Override
	public int result_print() {
		System.out.println("더하기 더하기 더하기");
		return 0;
	}
	
	public void addMethod1() {
		System.out.println("추가된 메소드");
	}

}
