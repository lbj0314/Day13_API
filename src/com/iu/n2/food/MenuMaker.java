package com.iu.n2.food;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class MenuMaker {
	
	private ArrayList<String> lunchs;
	private ArrayList<String> dinners;
	
	public String selectMenu(String select) {
		Random random = new Random();
		String menu = null;
		if (select.equals("1")) {
			menu = lunchs.get(random.nextInt(lunchs.size()));
		} else if(select.equals("2")){
			menu = dinners.get(random.nextInt(dinners.size()));
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		return menu;
	}
	
	
	public void init() {
		lunchs = this.makeMenu("lunch.txt","-");
		dinners = this.makeMenu("dinner.txt", ",");
	}
	
	private ArrayList<String> makeMenu(String fileName, String delim) {
		//점심 메뉴를 하나 가져오기
		File file = new File("c:\\test", fileName);
		FileReader fr = null;
		BufferedReader br = null;
		String str = null;
		Boolean check = true;
		ArrayList<String> ar = new ArrayList<String>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while (check) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				StringTokenizer st = new StringTokenizer(str, delim);
				while (st.hasMoreTokens()) {
					ar.add(st.nextToken().trim());
				}//inside while

			}//outside while
//			for (int i = 0; i < ar.size(); i++) {
//				System.out.println(ar.get(i));
//			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
}


