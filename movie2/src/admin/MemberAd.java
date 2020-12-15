package admin;

import java.util.Scanner;

import member.Member;
import movie.MovieInfo;
import member.MemberController;

public class MemberAd {
	Scanner sc = new Scanner(System.in);

	public void MemPrint(MemberController mem) {
		System.out.println("------------ 회원 목록 --------------");
		if (mem.getSize() == 0) {
			System.out.println(" !! 회원이 존재하지 않습니다 !!  ");
			return;
		} else {
			for (Member i : mem.memList) {
				System.out.println(i);
			}
		}
	}

	public void MemSearch(MemberController mem) {
		System.out.println("------------ 회원 검색 --------------");
		if (mem.getSize() == 0) {
			System.out.println(" !! 회원이 존재하지 않습니다 !!  ");
		} else {
			System.out.print("  검색할 이름을 입력해주세요  >> ");
			String SId = sc.nextLine();
			for (int i = 0; i < mem.getSize(); i++) {
				if (mem.getLocate(i).getId().equalsIgnoreCase(SId)) {
					System.out.println(mem.getLocate(i));
				}
			}
		}
	}
}
