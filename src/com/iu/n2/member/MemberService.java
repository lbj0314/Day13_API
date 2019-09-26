package com.iu.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.iu.n2.Server3;

public class MemberService {
	
	private ArrayList<Member> members;
	ArrayList<Member> ar = new ArrayList<Member>();
	
	public void init() {
		members = this.makeMenu("member.txt",",");

	}
	private ArrayList<Member> makeMenu(String fileName, String delim) {
		//id,pw 가져오기
		File file = new File("c:\\test", fileName);
		FileReader fr = null;
		BufferedReader br = null;
		String str = null;
		Boolean check = true;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while ((str=br.readLine()) != null) {
				Member member =new Member();
				String [] m = str.split(delim);
				member.setId(m[0].trim());
				member.setPw(m[1].trim());
				
				ar.add(member);
			}//outside while
			System.out.println(ar.get(0));
			System.out.println(ar.get(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}//makeMenu
	
	public void memberLogin(String id, String pw) {
		String msg = null;
		for (int i = 0; i < members.size(); i++) {
			if (id.equals(ar.get(0)) || id.equals(ar.get(1))) {
				msg = "로그인 성공";
			} else {
				msg = "로그인 실패, ID나 PASSWORD를 확인하세요.";

			}
		}
//		return id, pw;
	}
	
	
}//class
