package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import admin.Admin;
import admin.MemberAd;
import admin.MovieAd;
import member.Member;
import member.MemberController;
import member.Reservation;
import movie.MovieController;
import movie.MovieInfo;

public class View {
   Scanner sc = new Scanner(System.in);
   MemberAd memAd = new MemberAd(); // 추가_연희
   MovieAd moAd = new MovieAd(); // 추가_연희
   Admin ad = new Admin(); // 추가_연희

   public View() {
   }

   public void mainview(MovieController mc, MemberController memc) throws Exception {
      Reservation res = new Reservation(mc,memc);

      label: while (true) {
         			System.out.println("===============================");
			System.out.println("  + 비트박스 영화관에 오신걸 환영 합니다 + ");
			System.out.println("===============================");
			System.out.println("         1.  로그인");
			System.out.println("         2.  회원가입");
			System.out.println("         0.  종료");
			System.out.println("===============================");
			System.out.print("  메뉴를 선택하여 주세요 >> ");
         int ch = sc.nextInt();
         switch (ch) {
         case 1:
            loginView(res, memc);
            break;
         case 2:
            joinMember(memc);
            break;
         case 0:
            break label;
         case 3:
            ad.AdminLogin(mc, memc); // 추가_연희
            mainAd(mc, memc);
         default:
            break;
         }
      }
   }
   public void joinMember(MemberController memc) throws IOException {
      FileSave fs = new FileSave();
      System.out.println("  [ID] 를 입력하여 주세요 >> ");
      String id = sc.next();
      System.out.println("  [PASSWORD] 입력하여 주세요 >> ");
      String password = sc.next();
      System.out.println("  [CARD NUMBER] 입력하여 주세요 >> ");
      String card = sc.next();
      Member member = new Member(id,password,card);
      memc.insert(member);
      fs.memListWriter(memc);
     System.out.println("<<  축하 합니다! 회원가입 되었습니다!  >>");
     System.out.println();

      
   }
   void loginView(Reservation res, MemberController memc) throws Exception {

      System.out.println();
      System.out.print("[ID]  :");
      String id = sc.next();
      System.out.print("[PASSWORD]  :");
      String pass = sc.next();
      boolean dec = findId(id, pass, memc);
      while (dec) {
         			System.out.println();
			System.out.println("     <<  회원 서비스 입니다  >>     ");
			System.out.println("===============================");
			System.out.println("         1.  예매 하기");
			System.out.println("         2.  나의 예매 확인하기");
			System.out.println("         0.  상위메뉴");
			System.out.println("===============================");
			System.out.print("  메뉴를 선택하여 주세요 >> ");
         int ch = sc.nextInt();
         switch (ch) {
         case 1:
            res.service(id,memc);
            break;
         case 2:
        	 myReserve(res,id,memc);
            break;
         case 0:
            return;
         default:
            System.out.println(" !! 다시 입력  !! ");
            break;
         }
      }
   }
   public boolean findId(String id, String pass, MemberController memc) {
      if (memc.memList != null) {
         for (int i = 0; i < memc.memList.size(); i++) {
            if (id.equals(memc.getLocate(i).getId()) && pass.equals(memc.getLocate(i).getPassword())) {
              System.out.println();
            	System.out.println("	[" + memc.memList.get(i).getId() + "]님 로그인 되었습니다!");
               return true;
            }
         }
      }
      return false;
   }
   void myReserve(Reservation res,String id,MemberController memc) throws Exception {

	  System.out.println();
	  System.out.println("     <<  나의 예매 내역  >>     ");
	  memc.getLocate(memc.findId(id)).getSelectMovie();
	  System.out.println("===============================");
		System.out.println("          1.  다시 예매 하기");
		System.out.println("          2.  예매 취소 하기");
		System.out.println("          0.  상위 메뉴");
		System.out.println("===============================");
		System.out.println("메뉴를 선택하여 주세요 >> ");
      int ch = sc.nextInt();
      
      switch (ch) {
      case 1:
    	  res.cancel(id, memc);
    	  res.service(id, memc);
         break;
      case 2:
    	  res.cancel(id, memc);
         // 에매취소 호출
         break;
      case 0:
    	  return;
      }
   }

   public void mainAd(MovieController mc, MemberController memc) throws IOException {

      while (true) {
        			 System.out.println	("     <<  관리자 메뉴 입니다  >>     ");
			System.out.println("===============================");
			System.out.println("         1.  영화 관리");
			System.out.println("         2.  회원 관리");
			System.out.println("         0.  상위 메뉴");
			System.out.println("===============================");
			System.out.println("  메뉴를 선택하여 주세요 >> ");

         System.out.println("메뉴를 선택하여 주십시오.");
         int ch = sc.nextInt();
         switch (ch) {
         case 1:
            movieAd(mc); // Admin.MovieAd 호출_연희
            break;
         case 2:
            memberAd(memc); // Admin.MovieAd 호출_연희
            break;
         case 0:
            return;
         default:
            System.out.println("잘못입력하셨습니다.");
            break;
         }
      }

   }

   public void movieAd(MovieController mc) throws IOException {

      while (true) {
        			System.out.println("     <<  영화 관리 메뉴 입니다  >>     ");
			System.out.println("===============================");
			System.out.println("         1.  영화 목록");
			System.out.println("         2.  영화 추가");
			System.out.println("         3.  영화 수정");
			System.out.println("         4.  영화 삭제");
			System.out.println("         0.  상위 메뉴");
			System.out.println("===============================");

			System.out.println("  메뉴를 선택하여 주세요 >> ");
         int ch = sc.nextInt();
         switch (ch) {
         case 1:
            moAd.MPrint(mc); // Admin.MovieAd.MovieAdd 호출_연희
            break;
         case 2:
            moAd.MAdd(mc); // Admin.MovieAd.MovieAdd 호출_연희
            break;
         case 3:
            moAd.MUpdate(mc); // Admin.MovieAd.MovieUpdate 호출_연희
            break;
         case 4:
            moAd.MRemove(mc); // Admin.MovieAd.MovieRemove 호출_연희
            break;
         case 0:
            return;
         default:
            System.out.println(" !! 잘못 입력 !! ");
	System.out.println();
            break;
         }
      }
   }

   public void memberAd(MemberController mem) {

      		System.out.println("     <<  회원 관리 메뉴 입니다  >>     ");
		System.out.println("===============================");
		System.out.println("         1.  회원 전체 목록");
		System.out.println("         2.  회원 검색");
		System.out.println("         0.  상위 메뉴");
		System.out.println("===============================");
		System.out.println("  메뉴를 선택하여 주세요 >> ");

 
      int ch = sc.nextInt();
      switch (ch) {
      case 1:
         memAd.MemPrint(mem); // Admin.memberAd.MemberList 호출_연희
         break;
      case 2:
         memAd.MemSearch(mem); // Admin.memberAd.MemberSearch 호출_연희
         break;
      case 0:
         return;
      default:
         System.out.println(" !! 잘못 입력 !! ");
         break;
      }
   }

}