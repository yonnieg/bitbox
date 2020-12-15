package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import member.MemberController;
import movie.MovieController;

public class FileSave {

	public void mListWriter(MovieController mList) throws IOException {
		try {
			OutputStream out = new FileOutputStream("movieList.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(out);

			out2.writeObject(mList);
			out2.close();
		} catch (Exception e) {		}
	}

	public MovieController mListReader() throws IOException, ClassNotFoundException {
		File f = new File("movieList.dat");
		if (f.isFile()) {
			MovieController mList = null;
			try {
				InputStream in = new FileInputStream(f);
				ObjectInputStream in2 = new ObjectInputStream(in);

				mList = (MovieController) in2.readObject();
				in2.close();

			} catch (Exception e) {			}
			return mList;
		} else
			return null;
	}
	
	public void memListWriter(MemberController memList) throws IOException {
		try {
			OutputStream out = new FileOutputStream("memberList.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(out);
			out2.writeObject(memList);
			out2.close();

		} catch (Exception e) {		}
	}
	
	public MemberController memListReader() throws IOException, ClassNotFoundException {
		File f1 = new File("memberList.dat");
		if (f1.isFile()) {
			MemberController memList = null;
			try {
			InputStream in = new FileInputStream(f1);
			ObjectInputStream in2 = new ObjectInputStream(in);
			
			memList = (MemberController) in2.readObject();
			in2.close();
			} catch (Exception e) {			}
			return memList;
		} else
			return null;
	}

}