package com.iu.n2;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import com.iu.n2.network.Network;

public class Client3 {

	public static void main(String[] args) {
		//Id 입력
		//pw 입력
		//보낼땐 id+pw
		//서버로 전송
		//받아서는 나눔
		Socket sc = null;
		Scanner ssc = new Scanner(System.in);
		Network nw = new Network();
		String msg = null;
		try {
			sc = new Socket("211.238.142.39", 8282);
			System.out.println("id를 입력하세요.");
			String id = ssc.next();
			System.out.println("pw를 입력하세요.");
			String pw = ssc.next();
			msg = id+","+pw;
			nw.send(sc, msg);
			msg = nw.receive(sc);
			if (msg.equals("1")) {
				System.out.println("로그인 성공");
				System.out.println(id+"님 환영합니다.");
			}else if(msg.equals("0")){
				System.out.println("로그인 실패");
				System.out.println("id나 pw를 확인하세요.");
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
