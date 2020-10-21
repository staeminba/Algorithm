package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B1463_1�θ���� {
	static int N;
	static int[] dp;
    public static void main(String[] args) throws IOException {
    	BufferedReader br;
    	br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	
    	dp = new int[N+1];
    	dp[1] = 0;
    	
    	
    	int result = 0;
    	for (int i = 2; i <= N; i++) {
    		dp[i] = dp[i-1] + 1;
    		if( i % 2 == 0)
    			dp[i] = Math.min( dp[i] , dp[i/2] + 1);
    		if( i % 3 == 0)
    			dp[i] = Math.min( dp[i] , dp[i/3] + 1);
    		
		}
    	System.out.println(dp[N]);
    
    	
    }
	
}