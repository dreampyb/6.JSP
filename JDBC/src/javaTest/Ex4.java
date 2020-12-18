package javaTest;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
// 메뉴선텍( w:글쓰기, r:글읽기, d:글삭제, q:종료): w
// 글쓰기를 선택하셨습니다.
// 문자열을 받아 선택하세요.
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴선택(w:글쓰기, r:글읽기, d:글삭제, q:종료):");
		String menu =scan.nextLine();
		do {
		if(menu.equals("w")) {
			System.out.println("글쓰기를 선택하셨습니다.");
		} else if(menu.equals("r")) {
			System.out.println("글읽기를 선택하셨습니다.");
		} else if(menu.equals("d")) {
			System.out.println("글삭제를 선택하셨습니다.");
		} // input=="r"이런식으로 안하는 이유? 참조타입이므로
		  // 객체이니깐, 객체는 주소값이니깐, 
		  // 그 가리키고 있는 객체안의 내용을 비교하는 것이므로
	}while(!(menu.equals("q")));
		scan.close();	
		System.out.println("종료");
	}
}
