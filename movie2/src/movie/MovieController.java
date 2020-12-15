package movie;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieController implements Serializable {
	public ArrayList<MovieInfo> mList;

	public MovieController() {
	}

	public MovieController(ArrayList<MovieInfo> mList) {
		this.mList = mList;
	}

	public int getSize() {
		return mList.size();

	}

	public void insert(MovieInfo a) {
		mList.add(a);
	}

	public void remove(MovieInfo a) {
		mList.remove(a);
	}

	public MovieInfo getLocate(int num) {
		return mList.get(num);
	}

}