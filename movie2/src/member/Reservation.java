package member;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import main.FileSave;
import movie.MovieController;
import movie.MovieInfo;

public class Reservation implements Serializable{
	
	ArrayList<MovieInfo> mList;
	ArrayList<Member> memList;
	Scanner sc = new Scanner(System.in);
	Member member = new Member();
	
	public Reservation(MovieController mc, MemberController memc) {
		this.mList = mc.mList;
		this.memList = memc.memList;
	}
	
	void printMovie() {
		if(mList.size() != 0) {
			for(int i=0; i<mList.size(); i++) {
				System.out.println("     [제     목] : " + mList.get(i).getTitle() + 
								 "\n     [감     독] : "+ mList.get(i).getDirector() + 
								 "\n     [평     점] : " + mList.get(i).getScore() +
								 "\n     [출시연도] : " + mList.get(i).getYear());
				System.out.println("-------------------------------------------");
			}
		}
		else {
			System.out.println();
			System.out.println(" !! 현재 상영중인 영화가 없습니다 !!  ");
			System.out.println("상위 메뉴로 이동합니다.");
			System.out.println();
		}
	}
	
	public void service(String id,MemberController memc) throws Exception {
		FileSave file = new FileSave();
		printMovie();
		System.out.println();
		System.out.print("  [영화 제목]을 작성하여 주세요  >> ");
		String movie = selMovie();
		String showTimes = mvTime(movie);
		String showTime = selMovieTime(movie,showTimes);
		String seat = seat(memc);
		memc.getLocate(memc.findId(id)).setselAll(movie,showTime,seat);
		//memc.insert(member);
		Payment(memc,id);
		file.memListWriter(memc);
	}
	void Payment(MemberController memc,String id) {
		
		System.out.println();
		System.out.println("<< 결제하시겠습니까? ( Y / N ) >>");
		String i = sc.next();
		if (i.toUpperCase().equals("Y")) {
			System.out.println(" !! 결제 되었습니다 !!  ");
			memc.getLocate(memc.findId(id)).getSelectMovie();
		} else if (i.toUpperCase().equals("N")) {
			System.out.println(" !! 결제가 취소 되었습니다 !!  ");

		}
	}
	
	public String selMovie() {
		
		String movie = sc.next();
		return movie;
	}
	
	public String mvTime(String movie) {
		
		String showTimes = null;
		if (mList.get(0).getTitle().equals(movie)) {
			showTimes = "[상영 시간] : 1. [10:00] / 2. [14:00] / 3. [18:00] ";
		} else if (mList.get(1).getTitle().equals(movie)) {
			showTimes = "[상영 시간] : 1. [09:00] / 2. [12:00] / 3. [15:00] ";
		} else if (mList.get(2).getTitle().equals(movie)) {
			showTimes = "[상영 시간] : 1. [12:00] / 2. [17:00] / 3. [22:00] ";
		} else {
			System.out.println(" !! 잘못된 입력 입니다 !!   ");
		}
		return showTimes;

	}
	String selMovieTime(String movie,String showTimes) {
		
		System.out.println(showTimes);
		//System.out.print("  [영화 시간]을 선택하세요  >>");
		int time = sc.nextInt();
		if(time>0 && time<4) {
			if(movie.equals(mList.get(0).getTitle())) {
				if(time == 1) {
					return "[10:00]";
				}
				else if(time == 2) {
					return "[14:00]";
				}
				else if(time == 3) {
					return "[18:00]";
				}
			}
			else if(movie.contentEquals(mList.get(1).getTitle())) {
				if(time == 1) {
					return "[09:00]";
				}
				else if(time == 2) {
					return "[12:00]";
				}
				else if(time == 3) {
					return "[15:00]";
				}
			}
			else if(movie.equals(mList.get(2).getTitle())) {
				if(time == 1) {
					return "[12:00]";
				}
				else if(time == 2) {
					return "[17:00]";
				}
				else if(time == 3) {
					return "[22:00]";
				}
			}
		}
		return null;
	}
	String seat(MemberController memc) {
		Object[][] seats = getSeat(memc);

		printSeat(seats);

		// 좌석 선택
		System.out.print("     <<  좌석 선택   >>     ");
		System.out.println(" Ex) A열 4행 : A4 >> ");
		String Myseat = sc.next();
		// 입력받은 값 하나씩 쪼개기
		String[] array_Myseat;
		array_Myseat = Myseat.split("");
		getIndex(seats, array_Myseat);
		printSeat(seats);
		System.out.printf("선택한 좌석 " + "(%s)" + " 으로 예약하겠습니까? ( Y / N )  >>", Myseat);
		String ch = sc.next();
		if (ch.equalsIgnoreCase("Y")) {
			// 결제창으로
			// 선택좌석 배열에 저장
		} else if (ch.equalsIgnoreCase("N")) {
			seat(memc);
		}  

		return Myseat;
	}

	//선택 불가 좌석 표시되도록 수정 - 이동희
	public Object[][] getSeat(MemberController memc) {
		Object[][] seats = new Object[6][6];
		int cnt=0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (i == 0 && j == 0) {
					seats[i][j] = " ";
				} else if (i == 0 && j != 0) {
					seats[i][j] = " " + j + " ";
				} else if (i != 0 && j == 0) {
					seats[i][j] = (char) (64 + i);
				} else
					seats[i][j] = " _ ";
			}
		}
		for(int x=0;x<memc.getSize();x++) {
			if(memc.getLocate(x).getSelectSeat()!=null) 
				cnt++;
		}
		if(cnt==0) {
			return seats;
			// 배열 값 초기화
		}else {
			for(int x=0;x<memc.getSize();x++) {
				if(memc.getLocate(x).getSelectSeat()!=null) {
					String Myseat = memc.getLocate(x).getSelectSeat();
					// 입력받은 값 하나씩 쪼개기
					String[] array_Myseat;
					array_Myseat = Myseat.split("");
					getIndex(seats, array_Myseat);
				}
			}
			return seats;
		}
	}

	public void printSeat(Object[][] seats) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print("\t\t" + seats[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("			x : 선택 불가 좌석  _ : 선택 가능 좌석");
		System.out.println();
	}

	public void getIndex(Object[][] seats, String[] array_Myseat) {
		int index1 = 0;
		int index2 = 0;
		
		// 선택 좌석 출력
		if (	array_Myseat[0].toUpperCase().equals("A")  
				|| array_Myseat[0].toUpperCase().equals("B") 
				|| array_Myseat[0].toUpperCase().equals("C")
				|| array_Myseat[0].toUpperCase().equals("D")
				|| array_Myseat[0].toUpperCase().equals("E")) {
			
			switch (array_Myseat[0]) {
			case "A":
				index1 = 1;
				break;
			case "B":
				index1 = 2;
				break;
			case "C":
				index1 = 3;
				break;
			case "D":
				index1 = 4;
				break;
			case "E":
				index1 = 5;
				break;
			}
		} else {
			// 다시 선택
		}
		if (array_Myseat[1].equals("1") || array_Myseat[1].equals("2") || array_Myseat[1].equals("3")
				|| array_Myseat[1].equals("4") || array_Myseat[1].equals("5")) {
			switch (array_Myseat[1]) {
			case "1":
				index2 = 1;
				break;
			case "2":
				index2 = 2;
				break;
			case "3":
				index2 = 3;
				break;
			case "4":
				index2 = 4;
				break;
			case "5":
				index2 = 5;
				break;
			}
		} else {
			// 다시 선택
		}
		seats[index1][index2] = " x ";
	}
	public void cancel(String id,MemberController memc) {
		memc.getLocate(memc.findId(id)).setSelectMovie(null);
		memc.getLocate(memc.findId(id)).setselectSeat(null);
		memc.getLocate(memc.findId(id)).setSelectShowTime(null);
	}
}
