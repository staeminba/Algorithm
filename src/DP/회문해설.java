package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 회문해설 {
	
	static char[] str;
	static int[][] dp;
	static int N;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	str = new char[1001];
    	dp = new int[1001][1001];
    	
    	str = br.readLine().toCharArray();
    	
    	N = Integer.parseInt(br.readLine());
    	
    	for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			bw.write(isPal(s-1,e-1)+"\n");
		}
    	bw.flush();bw.close();
    }

	private static int isPal(int s, int e) {
		// TODO Auto-generated method stub
		if(s == e) //짝수일때
			return 1;
		else if(e - s == 1) //홀수일때
			return str[s] == str[e] ? 1 : 0;
		
		if(dp[s][e] !=0 )
			return 1;
		if(str[s] == str[e])
			return dp[s][e] = isPal(s+1,e-1);
		return 0;
	}

	
}