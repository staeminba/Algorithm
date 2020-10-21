package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_치킨집사장님 {

	static int N;
	static long dp[];
	static long MOD = 1000000007;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        N = Integer.parseInt(br.readLine());
        if(N <= 2)
        	System.out.println(1);
        else{
	        dp = new long[N+1];
	        
	        dp[1] = 1;
	        dp[2] = 1;
	        
	        for (int i = 3; i <= N; i++) {
				dp[i] = dp[i-1]%MOD + dp[i-2]%MOD;
			}
	        System.out.println(dp[N]%MOD);
        }
    }

}