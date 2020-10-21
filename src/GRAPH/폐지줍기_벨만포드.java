package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 폐지줍기_벨만포드 {
	private static int T;
	private static int first;
	private static int last;
	private static int numCnt;
	private static int upperCnt;
	private static int totalCnt;
	private static int len;
	private static int cache[][] = new int[36][10];
	private static int record[] = new int[11];
	
	private static int dp[][] = {
//      0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5
		{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //0
		{1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //1
		{0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //2
		{0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //3
		{0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //4
		{0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //5
		{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //6
		{0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //7
		{0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //8
		{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //9
		{1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //10
		{0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //11
		{0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0}, //12
		{0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0}, //13
		{0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0}, //14
		{0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0}, //15
		{0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0}, //16
		{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0}, //17
		{0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}, //18
		{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0}, //19
		{0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0}, //20
		{0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0}, //21
		{0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0}, //22
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0}, //23
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0}, //24
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0}, //25
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1}, //26
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1}, //27
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0}, //28
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0}, //29
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,1,0,0,0,0}, //30
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,1,0,0,0}, //31
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,1,0,0}, //32
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,1,0}, //33
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,1}, //34
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0}  //35
	};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			len = 10;
			StringTokenizer st;
			int mon,day,hh,mm,ss;
			String monYear,time;
			st = new StringTokenizer(br.readLine()," ");
			monYear = st.nextToken();
			time = st.nextToken();
//			System.out.println("monYear : " + monYear + " time : " + time);
			
			st = new StringTokenizer(monYear,"/");
			mon = Integer.parseInt(st.nextToken());
			day = Integer.parseInt(st.nextToken());
//			System.out.println("mon : " + mon + " day : " + day);
			
			st = new StringTokenizer(time,":");
			hh = Integer.parseInt(st.nextToken());
			mm = Integer.parseInt(st.nextToken());
			ss = Integer.parseInt(st.nextToken());
//			System.out.println("hh : " + hh + " mm : " + mm + " ss : " + ss);
			
			
			
			first		= (day+ss) % 36;
			last		= (mon+hh+mm) % 36;
			numCnt		= (mm) / 10;
			upperCnt	= (ss) / 10;
//			System.out.println("first " + first + " last : " + last + " numCnt : " + numCnt + " upperCnt : " + upperCnt);
			System.out.println("#"+i+" "+solve(first,len,0));
		}
		/*numCnt = 5;
		//Arrays.fill(record,-1);
		System.out.println(solve(34,10,0));*/
	}

	private static int solve(int num, int length, int nCnt) {
		// TODO Auto-generated method stub
		//System.out.println("num : " + num + " length : " + length + " nCnt : " + nCnt);
		if(length != 1){
			record[length] = num;
		}
		if(length == 1){
			if(num == 28 && nCnt == numCnt){
				//System.out.println("num : " + num + " length : " + length + " nCnt : " + nCnt);
				record[1] = num;
				int upper = 0;
				boolean upperFlag = true;
				for (int i = 10; i > 0; i--) {
					for (int j = 10; j > 0; j--) {
						if(i == j){
							continue;
						}
						if(record[i] / 10 == 0){
							if(record[i] == record[j]){
								return 0;
							}
						}else{
							if(record[i] == record[j]){
								upperFlag = false;
							}
						}
					}
					if(record[i] / 10 != 0 && upperFlag){
						upper++;
					}
					//System.out.print(record[i] + " ");
				}
//				for (int i = 10; i > 0; i--) {
//					System.out.print(record[i] + " ");
//				}
//				System.out.println(upper);
				return 1 * combi(upper);
			}else{
				/*for (int i = 0; i < 10; i++) {
					System.out.print(record[i] + " ");
				}
				System.out.println();*/
				return 0;
			}
		}
		
		if(nCnt > numCnt){
			return 0;
		}
			
		int result = 0;
		for (int i = 0; i < 36; i++) {
			if(dp[num][i] == 1){
				if(i / 10 == 0){
					result += (solve(i, length-1, nCnt+1));
				}else{
					result += (solve(i, length-1, nCnt));
				}
			}
		}
		return result;
	}

	private static int combi(int upper) {
		// TODO Auto-generated method stub
		int p = 1;
		for (int i = 1; i <= upperCnt; i++) {
			p = p *(upper-i+1)/i;
		}
//		System.out.println("p : " + p);
		return p;
	}
}

