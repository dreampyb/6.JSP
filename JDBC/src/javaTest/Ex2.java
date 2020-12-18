package javaTest;

public class Ex2 {

	public static void main(String[] args) {
		//출력값 0~99사이의 값을 9번 출력합니다. 
		for(int i=0; i<10; i++) {
			int num=(int)(Math.random()*90)+10;
			System.out.println(num);
		}
		
		for(int i=0; i<10; i++) {
			int num=(int)(Math.random()*90)+10;
			System.out.println("♡["+num+"]");
		}
	}
}
