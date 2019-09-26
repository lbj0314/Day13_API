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
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		//1단계

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
			
			
			while(check) {
				sc = new Socket("211.238.142.39", 8282);
				os = sc.getOutputStream(); //byte
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				is = sc.getInputStream(); //byte
				ir = new InputStreamReader(is);//char
				br = new BufferedReader(ir);//String
				System.out.println("서버로 전송할 메시지를 입력하세요.");
				str = ssc.next();
				if (str.toLowerCase().equals("q")) {
					break;
				}//if
				bw.write(str+"\r\n");
				bw.flush();
				System.out.println("서버로 전송 완료");
				str = br.readLine();
				if (str.toLowerCase().equals("q")) {
					break;
				}//if
				System.out.println(str);
				System.out.println("서버로부터 메시지 받기 완료");
				System.out.println("----------------------------");
			}//while

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//catch
		}//finally
	}//main
}//class
