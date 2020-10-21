package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스키장만들기 {

	static int N;
	static int[][] dp; //[i][j] i에서 j까지의 최대 길이
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());					
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				result = Math.max(result, go(i,j,Integer.MAX_VALUE));				
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

	private static int go(int x, int y, int val) {
		// TODO Auto-generated method stub
		if(x < 1 || x > N || y < 1 || y > N || arr[x][y] >= val )
			return 0;
		if(dp[x][y] != -1)
			return dp[x][y];
		
		dp[x][y] = 1;
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			dp[x][y] = Math.max(dp[x][y], go(nx,ny,arr[x][y])+1);
			
		}
		
		return dp[x][y];
	}

}