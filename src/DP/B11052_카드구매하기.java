package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B11052_카드구매하기 {
	
	static int N;
	static int P[];
	
	static int dp[];
	static int max = 0;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        P = new int[N+1];
        dp = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
    	
    	System.out.println(dp());
    	
    	
    }
	private static int dp() {
		// TODO Auto-generated method stub
		dp[1] = P[1];
		for (int i = 2; i <= N; i++) {
			dp[i] = P[i];
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + P[j]);
			}
		}
		
		return dp[N];
	}
	
}