package com.iu.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.iu.n2.food.MenuMaker;
import com.iu.n2.network.Network;

public class Server2 {
	
	public static void main(String[] args) {
		Network network = new Network();
		MenuMaker mm = new MenuMaker();
		mm.init();
		try {
			System.out.println("클라이언트 받을 준비중");
			ServerSocket ss = new ServerSocket(8282);
			Socket sc = ss.accept();
			String select = network.receive(sc);
			
			String menu = mm.selectMenu(select);
			
			network.send(sc, menu);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	
		
		

	}

}
