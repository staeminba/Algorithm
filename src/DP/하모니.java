package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class �ϸ�� {
	
	static int N;
	static long result;
	static long dp[][]; //dp[i][s] �������� �� �Ҹ��� s�̰� ,i���� ������� �� �� �ִ� ȭ���� ��
	static final int MOD = (int) 1e9;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];
        for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if(i==1)
					dp[i][j] = 1;
				else{
					if(j>0)
						dp[i][j] += dp[i-1][j-1];
					if(j<9)
						dp[i][j] += dp[i-1][j+1];
					dp[i][j] %= MOD;
				}
				if(i == N){
					result += dp[i][j];
					result %= MOD;
				}
			}
		}
        System.out.println(result);
    }

}