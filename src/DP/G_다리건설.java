package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_다리건설 {

	static int N,S;
	static int arr[];
	static int dp[];
	static int result;
	static int pos;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        dp[1] = arr[1];
        System.out.println(solve());
    }

   /* public static int solve() {
    	for (int i = 2; i <= N; i++) {
    		int max = 0;
    		for (int j = 1; j < i; j++) {
				if(arr[i] > arr[j]){
					dp[i] = Math.max(dp[i] , dp[j]+1);
					System.out.println("dp["+i+"] : " + dp[i] );
				}
			}
    		if(dp[i] > result){
    			result = dp[i];
    		}
		}
    	return result;
	}*/
    
    public static int solve() {
    	int pos = 1;
    	for (int i = 2; i <= N; i++) {
    		if(arr[i] > dp[pos])
    			dp[++pos] = arr[i];
    		else{
    			int num = lowerBound(i);
    			dp[num] = arr[i];
    		}
		}
    	return pos;
	}

private static int lowerBound(int n) {
	// TODO Auto-generated method stub
	for (int i = 1; i <= n; i++) {
		if(dp[i] >= arr[n] )
			return i;
	}
	return n;
}
}