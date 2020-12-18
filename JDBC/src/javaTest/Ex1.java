package javaTest;

public class Ex1 {

	public static void main(String[] args) {
		// 1~10까지 찍어봅시다 (단, for문을 이용할 것)
//		for(int i=0; i<11; i++){
//			if(i%2==0) {
//			System.out.println();
//		  }
//		}	
		// 10회 램덤으로 찍습니다..(1~10사이의 수를)
//		for(int i=0; i<10; i++){
//			int num = (int)(Math.random()*10)+1;
//			System.out.println(num);
//		}
//		출력시 랜덤으로 나온 숫자만큼 띄어쓰기 *2를 해서 출력하시오
/* 
 												re:10
 								re:8
 					re:1
 */
		for(int i=0; i<10; i++){
			int num = (int)(Math.random()*10)+1;
			
		for(int j=0; j<num; j++){
			System.out.print(" ");
		}
			System.out.println("⤷ re:" + num);
		}
	}
}
