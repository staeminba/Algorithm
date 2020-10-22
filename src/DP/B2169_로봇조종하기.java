package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2169_로봇조종하기 {

	static int N,M;
	static int[][] arr;
	static int[][] temp;
	static int[][] dp;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N+1][M+1];
    	dp = new int[N+1][M+1];
    	temp = new int[2][M+2];
    	
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	dp[1][1] = arr[1][1];
    	for (int j = 2; j <= M; j++) { //첫재쭐은 시작점이 1,1이므로 오른쪽만 가능
			dp[1][j] = dp[1][j-1] + arr[1][j];
		}
    	
    	for (int i = 2; i <= N; i++) {
    		temp[0][0] = dp[i-1][1]; 
    		for (int j = 1; j <= M; j++) { //오른쪽으로
				temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + arr[i][j];
			}
    		
    		temp[1][M+1] = dp[i-1][M];
    		for (int j = M; j >= 1; j--) { //왼쪽으로
				temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + arr[i][j];
			}
    		
    		for (int j = 1; j <= M; j++) { //오른쪽으로
				dp[i][j] = Math.max(temp[0][j], temp[1][j]);
			}
    	}
    	
    	System.out.println(dp[N][M]);
    }
	
}