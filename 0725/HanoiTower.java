package com.ssafy.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTower {
	
	static int k = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		System.out.println((1<<N)-1);		//몇번 이동하면 되는지
		hanoi(1, 3, N);
		System.out.println(sb);
	}
	
	// 시작 나머지 목적지
	public static void hanoi(int start, int dest, int num) {
		if(num==0) return;
		hanoi(start, 6 -start-dest, num-1);	//나머지 칸에 n-1을 쌓는거
		sb.append(start+" "+dest+"\n");	//	제일 큰 1개를 목적지에 쌓는거
//		System.out.println(start+" "+dest);
		hanoi(6-start-dest, dest, num-1);	//나머지 칸에 쌓여있는 n-1개의 상자를 목적지에 쌓는 것
	}

}
