package admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import main.FileSave;
import movie.MovieController;
import movie.MovieInfo;

public class MovieAd {
//	FileSave Fs = new FileSave();
	Scanner sc = new Scanner(System.in);

	public void MPrint(MovieController mc) {
		System.out.println("------------ 영화 목록 ------------");
		if (mc.getSize() == 0) {
			System.out.println(" !! 영화가 존재하지 않습니다 !!  ");
			return;
		} else {
			for (MovieInfo i : mc.mList) {
				System.out.println(i);
			}
		}
	}

	public void MAdd(MovieController mc) throws IOException {
		FileSave Fs = new FileSave();
		System.out.println("-------------- 영화 추가하기 --------------");
		if (mc.getSize() == 3) {
			System.out.println(" !! 상영관이 가득 찼습니다 !!  ");
			return;
		}	while (true) {
			for (int i = 0; i <= mc.getSize(); i++) {
				System.out.print("  [추가] 영화 제목  >> ");
				String movie = sc.nextLine();
				System.out.print("  [추가] 영화 감독명  >> ");
				String director = sc.nextLine();
				System.out.print("  [추가] 영화 평점  >> ");
				String score = sc.nextLine();
				System.out.print("  [추가] 제작년도  >> ");
				String year = sc.nextLine();
				MovieInfo a = new MovieInfo(movie, director, score, year);
				mc.insert(a);
				Fs.mListWriter(mc);
				System.out.println(" !! 영화가 추가 되었습니다 !!  ");
				System.out.println("  더 추가 하시겠습니까? ( Y / N )");
				String answer = sc.nextLine();
				if (answer.equalsIgnoreCase("Y"))
					break;
				else
					return;
			}
		}
	}

	public void MUpdate(MovieController mc) throws IOException {
		FileSave Fs = new FileSave();
		System.out.println("--------------영화 정보 수정 --------------");
		if (mc.getSize() == 0) {
			System.out.println(" !! 영화가 존재하지 않습니다 !!  ");
			return;
		} else {
			System.out.print("  영화제목 입력  >>");
			String movie = sc.nextLine();

			for (int i = 0; i < mc.getSize(); i++) {
				if (mc.getLocate(i).getTitle().equalsIgnoreCase(movie)) {
					System.out.print("  [수정] 영화제목 입력  >> ");
					mc.getLocate(i).setTitle(sc.nextLine());
					System.out.print("  [수정] 감독 입력  >> ");
					mc.getLocate(i).setDirector(sc.nextLine());
					System.out.print("  [수정] 평점 입력  >> ");
					mc.getLocate(i).setScore(sc.nextLine());
					System.out.print("  [수정] 제작년도 입력  >> ");
					mc.getLocate(i).setYear(sc.nextLine());
					Fs.mListWriter(mc);
					System.out.println(" !! 해당 영화가 수정 되었습니다 !!  ");

				}
			}
		}
		return;
	}

	public void MRemove(MovieController mc) throws IOException {
		FileSave Fs = new FileSave();
		System.out.println("---------영화 삭제---------");
		if (mc.getSize() == 0) {
			System.out.println(" !! 영화가 존재하지 않습니다!!  ");
			return;
		} else {
			System.out.print("  [삭제] 영화제목 입력  >>");
			String movie = sc.nextLine();

			for (int i = 0; i < mc.getSize(); i++) {
				if (mc.getLocate(i).getTitle().equalsIgnoreCase(movie)) {
					mc.remove(mc.getLocate(i));
					Fs.mListWriter(mc);
					System.out.println(" !! 해당 영화가 삭제 되었습니다!!  ");
				}
			}
		}
		return;
	}
}
