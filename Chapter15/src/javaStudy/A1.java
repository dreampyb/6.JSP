package javaStudy;

public class A1 implements Cal {

	@Override
	public int result(int a, int b) {
		//���ϱ� ����
		return a+b;
	}

	@Override
	public int result_print() {
		System.out.println("���ϱ� ���ϱ� ���ϱ�");
		return 0;
	}
	
	public void addMethod1() {
		System.out.println("�߰��� �޼ҵ�");
	}

}
