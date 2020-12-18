package javaTest;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// 글쓰기입니다.
		// 제목 입력해 주세요:   제목이다
		// 글쓴이를 입력해주세요 : 글쓴이다
		// 비밀번호를 입력주세요: 패스워드다
		// 내용을 입력해 주세요 : 네용이다.
		// 입력완료. 입력하신 내용은 
		// 제목 :        내용 : 		............
		Scanner scan =new Scanner(System.in);
		System.out.println("글쓰기입니다");
		System.out.print("제목 입력해 주세요 : ");
		String subject =scan.nextLine();
		System.out.print("글쓴이를 입력해주세요 : ");
		String name =scan.nextLine();
		System.out.print("비밀번호를 입력주세요 : ");
		String passw =scan.nextLine();
		System.out.print("내용을 입력해 주세요 : ");
		String content =scan.nextLine();
		System.out.println();
		System.out.println("입력완료. 입력하신 내용은");
		System.out.println("제목: "+ subject);
		System.out.println("글쓴이"+ name);
		System.out.println("비밀번호 :"+ passw);
		System.out.println("내용"+ content);
	}
}