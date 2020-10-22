package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B12865_Æò¹üÇÑ¹è³¶ {
	
	static int N,K;
	static int[] W;
	static int[] V;
	static int[][] dp;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br;
    	StringTokenizer st;
    	br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	W = new int[N+1];
    	V = new int[N+1];
    	dp = new int[N+1][K+1];
    	
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		W[i] = Integer.parseInt(st.nextToken());
    		V[i] = Integer.parseInt(st.nextToken());
    	}
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j >= W[i]){
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - W[i]] + V[i]);
				}else
					dp[i][j] = dp[i-1][j];
			}
		}	
    	System.out.println(dp[N][K]);
    }
	
}