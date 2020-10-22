package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B11722_가장긴감소하는부분수열 {
 

	static int N;
	static int max;
	static int ans = 0;
	static int[] dp;
	static int[] arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dp  = new int[N+1];
        arr = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
		}
        
        System.out.println(add());
    }
    public static int add(){
    	for (int i = 1; i <= N; i++) {
    		max = 0;
    		for (int j = 1; j < i; j++) {
				if(arr[i] < arr[j]){
					if(dp[j] > max)
						max += 1;
				}
			}
    		dp[i] = max + 1;
    		//System.out.println("dp[i] : " + dp[i] + " ans : " + ans);
    		if(dp[i] > ans){
    			ans = dp[i];
    		}
		}
    	return ans;
    }
	
}