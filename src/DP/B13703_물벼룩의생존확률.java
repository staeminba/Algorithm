package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13703_물벼룩의생존확률 {

	static int K,N; //k:수면아래 cmm N:초 
	static long dp[][];
	static long result;
	
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	K = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	
    	dp = new long[64][128];
    	for (int i = 0; i < 64; i++) {
			Arrays.fill(dp[i], -1);
			
		}
    	result = solve(N,K);
    	
    	System.out.println(result);
    	
    	

    }

	public static long solve(int time,int dep) {
		// TODO Auto-generated method stub
		if (dep == 0) //잡아먹히면
			return 0;
		else if (time == 0) //살아있으면 
			return 1;

		//System.out.println("time : " + time + " dep : " + dep + " result : " + result + " dp[time][dep] : " + dp[time][dep]);
		/*dp[time][dep] = result;*/
		if (dp[time][dep] != -1) 
			return dp[time][dep];
		result = solve(time - 1, dep + 1) + solve(time - 1, dep - 1);
		dp[time][dep] = result;
		return result;

	}

}