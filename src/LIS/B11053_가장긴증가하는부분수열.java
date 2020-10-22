package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B11053_가장긴증가하는부분수열 {
 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		
		int[] dp = new int[t+1];
		int[] arr = new int[t+1];
		    
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= t; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	    int n, i, j, max = 0;
	    Arrays.fill(dp, 1); // 자신만 포함한 부분수열도 최장증가수열이라고 할 수 있으므로 '1'로 초기화
	    for(i = 1; i <= t; i++){
	    	for(j = 1; j <= i; j++){
	    		if(arr[i] <= arr[j]) continue; // 'j'번쨰 원소가 'i'번쨰 원소보다 크면 j번쨰 원소는 최장증가수열에 포함되지 않는다.
	    		dp[i] = Math.max(dp[i], dp[j]+1);
	    	}
	    	max = Math.max(max, dp[i]); // 최장증가수열 중에서도 길이가 가장 긴 것을 찾는다.
	    }
	    System.out.println(max);
	}
}
