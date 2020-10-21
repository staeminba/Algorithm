package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_세계여행_TSP_상 {
	
	static int N;
	static int[][] map;
	static int[][] dp;
	static final int MAX = 987654321;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][1<<N];
        
        String line[];
    	for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	System.out.println(tsp(0,1));
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
    
    public static int tsp(int now,int next){
			if(next == (1 << N)-1)
				return map[now][0] != 0 ? map[now][0] : MAX;
			
			if(dp[now][next] > 0)
				return dp[now][next];
			
			dp[now][next] = MAX;
			for(int i = 0; i < N; i++){
				if((next & 1<<i) >0 )
					continue;
				if(map[now][i] == 0)
					continue;
				
				dp[now][next] = Math.min(dp[now][next], tsp(i, next | 1 << i) + map[now][i]);
			}
			return dp[now][next];
			
				
		}

}