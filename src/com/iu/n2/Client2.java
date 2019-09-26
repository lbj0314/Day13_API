package com.iu.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.iu.n2.network.Network;

public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 점심메뉴
		// 2. 저녁메뉴
		// 스캐너로 선택
		
		Socket sc = null;
		Scanner ssc = new Scanner(System.in);
		Network network = new Network();
		try {
			sc = new Socket("211.238.142.39", 8282);
			System.out.println("1. 점심 메뉴");
			System.out.println("2. 저녁 메뉴");
			String select = ssc.next();
			network.send(sc, select);
			
			select = network.receive(sc);
			System.out.println(select);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}//main

}//class
