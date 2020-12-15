package main;

import java.io.IOException;
import java.util.ArrayList;

import member.Member;
import member.MemberController;
import movie.MovieController;
import movie.MovieInfo;

public class MainApp {

	public static void main(String[] args) throws Exception {
		View view = new View();
		FileSave save = new FileSave();

		ArrayList<MovieInfo> MList = new ArrayList<>();
		ArrayList<Member> MemList = new ArrayList<>();
		
		MovieController mc = save.mListReader();
		if(mc == null) {
			mc = new MovieController(MList);
			save.mListWriter(mc);
		}
		MemberController memc = save.memListReader();
		if(memc == null) {
			memc = new MemberController(MemList);
			save.memListWriter(memc);
		}
		
		view.mainview(mc,memc);
	}
}