package com.iu.n2.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Network {
	
	public void send(Socket sc, String msg) throws Exception {
		
		//입력값 보내기
		OutputStream os = sc.getOutputStream(); // byte
		OutputStreamWriter ow = new OutputStreamWriter(os); //char
		BufferedWriter bw = new BufferedWriter(ow);
		bw.write(msg+"\r\n");
		bw.flush();
		
	}
	
	public String receive(Socket sc) throws Exception {
		
		//출력값 받기
		InputStream is = sc.getInputStream();
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		String msg = br.readLine();
		
		return msg;
	}
	
	
	
	
}
