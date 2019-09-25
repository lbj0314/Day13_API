package com.iu.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		//ServerSocket
		//Socket
		ServerSocket ss = null;
		Socket sc = null;
		//읽기
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		//쓰기
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		String str = null;
		Scanner ssc = new Scanner(System.in);
		boolean check = true;
		try {
			ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속받을 준비중");
			sc = ss.accept();
			is = sc.getInputStream(); //byte
			ir = new InputStreamReader(is);//char
			br = new BufferedReader(ir);//String

			os = sc.getOutputStream(); //byte
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			while(check) {
				
				str = br.readLine();
				if (str.toLowerCase().equals("q")) {
					break;
				}//if
				System.out.println(str);
				System.out.println("클라이언트로부터 메시지 받기 완료");
				System.out.println("----------------------------");
				System.out.println("클라이언트에게 보낼 메시지를 입력하세요.");

				str = ssc.next();
				bw.write(str+"\r\n");
				bw.flush();

				System.out.println("클라이언트로 전송 완료");
			}//while

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				sc.close();
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//finally
	}//main

}//class
