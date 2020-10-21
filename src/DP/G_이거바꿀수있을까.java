package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_이거바꿀수있을까 {

	static int N, K;
	static int[] arr;
	static int[] dp;
	static int result;

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    	
    	Arrays.sort(arr);
    	K = Integer.parseInt(br.readLine());
    	dp = new int[100001];
    	
    	for (int i = 0; i <= K; i++) {
    		dp[i] = Integer.MAX_VALUE-1;
    	}
    	for (int num : arr) {
    		
			dp[num] = 1;
		}
    	for (int i = 1; i <= K; i++) {
    		
    		for (int j = 0; j < N && i - arr[j] >= 0; j++) {
    			
				dp[i] = Math.min(dp[i], dp[i - arr[j]]+1);
			}
		}
    	System.out.println(dp[K] > 100000 ?  -1 : dp[K]);
    	
    }
}