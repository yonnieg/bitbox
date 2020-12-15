package member;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.FileSave;

public class MemberController implements Serializable {
	public ArrayList<Member> memList;

	public MemberController() {
	}

	public MemberController(ArrayList<Member> memList) {
		this.memList = memList;
	}

	public int getSize() {
		return memList.size();
	}

	public void insert(Member a) {
		memList.add(a);
	}

	public Member getLocate(int num) {
		return memList.get(num);
	}

	public int findId(String id) {
		for (int i = 0; i < memList.size(); i++) {
			if (memList.get(i).getId().equalsIgnoreCase(id))
				return (i);
		}	return -1;		
	}
}