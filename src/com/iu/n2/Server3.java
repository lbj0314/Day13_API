package com.iu.n2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.iu.n2.member.Member;
import com.iu.n2.member.MemberService;
import com.iu.n2.network.Network;

public class Server3 {

	public static void main(String[] args) {
		//id, pw 분리
		//return
		ServerSocket ss = null;
		Socket sc = null;
		MemberService ms = new MemberService();
		Network nw = new Network();
		try {
			System.out.println("클라이언트 연결 준비중");
			ms.init();
			ss = new ServerSocket(8282);
			sc = ss.accept();
//			System.out.println("클라이언트 연결 성공");
			String msg = nw.receive(sc);//id,pw
			String [] info = msg.split(",");
			Member member = new Member();
			member.setId(info[0]);
			member.setPw(info[1]);
			
			member = ms.memberLogin(member);
			msg = "0"; //로그인 실패
			if (member != null) {
				msg = "1"; //로그인 성공
			}			
			nw.send(sc, msg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sc.close();
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
