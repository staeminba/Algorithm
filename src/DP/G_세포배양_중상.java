package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_세포배양_중상 {

	static int N, A, B;
	static int[] dp;



	public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        N = Integer.parseInt(st.nextToken());
	        A = Integer.parseInt(st.nextToken());
	        B = Integer.parseInt(st.nextToken());

	        dp = new int[N+1];
	        Arrays.fill(dp,9876543);
	        dp[1] = A;
	        for (int i = 2; i <= N; i++) {
	        	
	        	if((i & 1) == 0){ //짝수면
	        		dp[i] = Math.min(dp[i-1]+A, dp[i/2]+ B);
	        	}else{//홀수
	        		dp[i] = Math.min(dp[i-1]+A, dp[(i+1)/2]+ A + B);
	        	}
	        }
	        System.out.println(dp[N]);
	        
	    }
}
