package admin;

import java.io.IOException;
import java.util.Scanner;

import main.View;
import member.MemberController;
import movie.MovieController;

public class Admin {
	final String AdminPw = "1111";
	Scanner sc = new Scanner(System.in);

	public void AdminLogin(MovieController mc, MemberController memc) {
		while(true){
		System.out.println("  관리자 비밀번호를 입력해주세요 >> ");
		String AdminPw = sc.nextLine();
		if (AdminPw.equals(this.AdminPw)) {
			return;
		}else {
			System.out.println(" !! 비밀번호 오류 !!  ");
		}
		}
	}

}
