package javaStudy;

public class B1 implements Cal {

	@Override
	public int result(int a, int b) {
		//����
		return a-b;
	}

	@Override
	public int result_print() {
		System.out.println("���� ���� ����");
		return 0;
	}
	
	public void addMethod2() {
		System.out.println("B1Ŭ������ �߰��� �޼ҵ�");
	}

}
