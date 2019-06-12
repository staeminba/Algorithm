package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class ¥ı«œ±‚_DP_9095 {
 

	static int T;
	static int[] dp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= T; i++) {
        	int n = Integer.parseInt(br.readLine());
			System.out.println(add(n));
		}
    }
    public static int add(int n){
    	dp = new int[12];
    	dp[1]=1;dp[2]=2;dp[3]=4;
    	for (int i = 4; i <= n; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
    	return dp[n];
    }
	
}