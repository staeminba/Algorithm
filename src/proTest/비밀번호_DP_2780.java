package proTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 비밀번호_DP_2780 {
	private static int T;
	private static int first;
	private static int last;
	private static int numCnt;
	private static int upperCnt;
	private static int[] key;
	private static int totalCnt;
	private static int len;
	
	private static int dp[][] = {
		{0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, //0

        {0, 0, 1, 0, 1, 0, 0, 0, 0, 0}, //1

        {0, 1, 0, 1, 0, 1, 0, 0, 0, 0}, //2

        {0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, //3

        {0, 1, 0, 0, 0, 1, 0, 1, 0, 0}, //4

        {0, 0, 1, 0, 1, 0, 1, 0, 1, 0}, //5

        {0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, //6

        {1, 0, 0, 0, 1, 0, 0, 0, 1, 0}, //7

        {0, 0, 0, 0, 0, 1, 0, 1, 0, 1}, //8

        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0} //9
	};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			len = Integer.parseInt(br.readLine()); 
			int sum = 0;
			sum += solve(first,len);
			
			System.out.println(sum);
		}
	}

	private static int solve(int num, int length) {
		// TODO Auto-generated method stub
		if(len == 0){
			return result;
		}
			
		int result = 0;
		for (int i = 0; i < 35; i++) {
			if(dp[num][i] == 1){
				result += (solve(i, length-1));
			}
		}
		return result;
	}
}

