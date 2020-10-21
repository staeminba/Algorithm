package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_πÊ√ªº“ {

	static int N;
	static int[][] arr;
	static int[][] dp;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	static int result = 0;
	

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	N = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	
    	arr = new int[N+1][N+1];
    	dp  = new int[N+1][N+1];
    	
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			dp[i][j] = Math.max(dp[i][j], 1);
    			solve(i,j);
			}
		}
    	
    	System.out.println(result);
    }


	private static int solve(int x, int y) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 4; i++) {
			if( (x+dx[i] > 0 && x+dx[i] <= N) && (y+dy[i] > 0 && y+dy[i] <= N) && (arr[x][y] > arr[x+dx[i]][y+dy[i]])){
				
				int nx = x+dx[i];
				int ny = y+dy[i];
				dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
				//System.out.println("("+x+","+y+") ("+nx+","+ny+") " + dp[nx][ny] + " " + dp[x][y]);
				result = Math.max(result, dp[nx][ny]);
				solve(nx,ny);
			}
		}
		return result;
	}
}