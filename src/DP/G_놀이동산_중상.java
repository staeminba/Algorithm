package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_놀이동산_중상 {

	static int N;
	static int[][] arr;
	static int[][] dp;
	static final int MAX = 987654321;
   

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];
        dp = new int[N][1<<N];
        
    	for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	System.out.println(tsp(0,1));
    }


	private static int tsp(int now, int next) {
		// TODO Auto-generated method stub
		if(next == (1<<N) -1){//모든점 방문했으면
			return arr[now][0] != 0 ? arr[now][0] : MAX;
		}
		
		if(dp[now][next] > 0){
			return dp[now][next];
		}
		
		dp[now][next] = MAX;
		for (int i = 0; i < N; i++) {
			if(((next & 1 << i) > 0) || (arr[now][i] == 0))//방문한적 있거나 갈수 없는 곳이면
				continue;
			
			dp[now][next] = Math.min(dp[now][next], tsp(i, (next | 1 << i)) + arr[now][i]);
		}
		
		
		return dp[now][next];
	}

   
}
