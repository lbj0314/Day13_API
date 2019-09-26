package com.iu.n2;

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
		Network network = new Network();
		String input = null;
		try {
			sc = new Socket("211.238.142.39", 8282);
			System.out.println("id를 입력하세요.");
			String id = ssc.next();
			System.out.println("pw를 입력하세요.");
			String pw = ssc.next();
			input = id+","+pw;
			System.out.println(input);
			network.send(sc, input);
			//
			
			String msg = network.receive(sc);
			System.out.println(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
	}

}
