package com.iu.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.iu.n2.Server3;

public class MemberService {

	private HashMap<String, Member> map;

//	public static void main(String[] args) {
//		MemberService ms = new MemberService();
//		try {
//			ms.init();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void init() throws Exception{
		this.map = new HashMap<String, Member>();

		File file = new File("c:\\test", "member.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		Boolean check = true;
		while(check) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(str, ",");
			while (st.hasMoreTokens()) {
				Member member = new Member();
				member.setId(st.nextToken().trim()); //id
				member.setPw(st.nextToken().trim()); //pw
				map.put(member.getId(), member);

			}//inside while

		}//outside while
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String k = it.next();
			Member member = map.get(k);
//			System.out.println(member.getId());
//			System.out.println(member.getPw());
		}


	}
	public Member memberLogin(Member member) {
		Member m = map.get(member.getId());
		if(m != null){
			if (m.getPw().equals(member.getPw())) {
				//추가 정보 대입
			} else {
				m = null; //null 집어 넣어서 실패로 처리
			}//inside if else
		}//outside if
		return m;
	}


	//	private ArrayList<Member> makeMenu(String fileName, String delim) {
	//		//id,pw 가져오기
	//		
	//		
	//		try {
	//			fr = new FileReader(file);
	//			br = new BufferedReader(fr);
	//			while ((str=br.readLine()) != null) {
	//				Member member =new Member();
	//				String [] m = str.split(delim);
	//				member.setId(m[0].trim());
	//				member.setPw(m[1].trim());
	//				
	//				ar.add(member);
	//			}//outside while
	//			System.out.println(ar.get(0));
	//			System.out.println(ar.get(1));
	//		} catch (Exception e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return ar;
	//	}//makeMenu
	//	


}//class
