package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_스노우보드 {

	static int N;
	static int[][] arr;
	static int[][] dp;
	static int[] dy = {-1,1};
	static int res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		
		arr[1][1] = dp[1][1] = Integer.parseInt(br.readLine().trim());
		res = dp[1][1];
		for (int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(j==1)
					dp[i][j] = dp[i-1][j] + arr[i][j];
				else if(j==i)
					dp[i][j] = dp[i-1][j-1] + arr[i][j];
				else
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
				
				res = Math.max(res,  dp[i][j]);
			}
			
		}
		
		System.out.println(res);

	}


}