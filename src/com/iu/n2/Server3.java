package com.iu.n2;

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
		Network network = new Network();
		MemberService ms = new MemberService();
		ms.init();
		
		try {
			ServerSocket ss = new ServerSocket(8282);
			Socket sc = ss.accept();
			String input = network.receive(sc);
			boolean check = true;
			ArrayList<String> ar = new ArrayList<String>();
			while (check) {
				if (input == null) {
					check = false;
					break;
				}
				StringTokenizer st = new StringTokenizer(input);
				while (st.hasMoreTokens()) {
					
					ar.add(st.nextToken().trim());
				}
				System.out.println(ar.get(0));
			
			}//outside while
			
//			String input = ms.memberLogin(id, pw);

//			network.send(sc, input);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
