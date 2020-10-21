package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_하모니2_중상 {
	
	static int N;
	static long result;
	static long dp[][][]; //dp[i][s] 마지막에 낸 소리가 s이고 ,i명의 사람으로 낼 수 있는 화응의 수
	static final int MOD = (int) 1e9+7;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10][1<<10];
        for (int i = 0; i < 10; i++) {
			dp[1][i][1<<i] = 1;
		}
        for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = (1<<10) - 1; k >= 0; k--) {
					if(j>0)
						dp[i][j][k | (1<<j)] += dp[i-1][j-1][k];
					if(j<9)
						dp[i][j][k | (1<<j)] += dp[i-1][j+1][k];
					dp[i][j][k | (1<<j)] %= MOD;
					
				}
				if(i == N){
					result += dp[i][j][(1<<10)-1];
					result %= MOD;
				}
				
				
			}
		}
        System.out.println(result);
    }

}