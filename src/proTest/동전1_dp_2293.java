package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class µ¿Àü1_dp_2293 {
 

	static int N;
	static int K;
	static int[] dp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N > 100 || N < 1)
        	return;
        if(K > 10000 || K < 1)
        	return;
        
        dp = new int[K+1];
        
        for (int i = 1; i <= N; i++) {
        	int n = Integer.parseInt(br.readLine());
        	if(n > 100000)
        		n = 0;
        	add(n);
        	/*for (int j = 1; j <= K; j++) {
				System.out.print(dp[j] + " ");
			}
        	System.out.println();*/
		}
        
        System.out.println(dp[K]);
    }
    public static void add(int n2){
    	/*if(n <= K){
    		dp[n] += 1;
    	}
    	for (int i = 1; i <= K; i++) {
    		if(i >= n && dp[i-n] > 0){ 
    			if(i-n == 0){
    				dp[i] += dp[1];
    			}else{
    				dp[i] += dp[i-n];
    			}
    		}
		}*/
    	dp[0] = 1;
		for (int j = n2; j <= K ; j++) {
			dp[j] += dp[j-n2]; 
		}
    }
	
}