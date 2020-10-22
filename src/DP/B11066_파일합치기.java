package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11066_파일합치기 {

	static int T;
	static int K;
	static int[] arr;
	static int[] sum;
	static int[][] dp;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	T = Integer.parseInt(br.readLine());
    	
    	for (int i = 1; i <= T; i++) {
			K = Integer.parseInt(br.readLine());
			arr = new int[K+1];
			sum = new int[K+1];
			dp = new int[K+1][K+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= K; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + arr[j];
			}
			for (int dist = 1; dist < K; dist++)
			{
				for (int x = 1; x+dist <= K; x++) //중간값
				{
					int y = x + dist;

					dp[x][y] = Integer.MAX_VALUE;
					for (int mid = x; mid < y; mid++)
					{
						int temp = dp[x][mid] + dp[mid + 1][y] + sum[y] - sum[x - 1];
						if(temp < dp[x][y])
							dp[x][y] = temp;
					}
				}
			}
			System.out.println(dp[1][K]);
    	}
    	
    }
	
}