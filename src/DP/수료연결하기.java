package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수료연결하기 {

	static int N;
	static int[][] dp;
	static ArrayList<Edge> list;
	static int result;
	static class Edge{
		int l,r;
		public Edge(int l,int r){
			this.l = l;
			this.r = r;
		}
		
	} 
	// dp[i][j] = i번째 파이프로부터 j번째 파이프까지 연결하기 위한 최소비용
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			list.add(new Edge(l,r));
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		bw.write(Integer.toString(go(0,N-1))+"\n");

		bw.flush();
		bw.close();
	}

	private static int go(int l, int r) {
		// TODO Auto-generated method stub
		if(l >= r)
			return 0;
		if(dp[l][r] != Integer.MAX_VALUE)
			return dp[l][r];
		
		for (int i = l; i < r; ++i) {
			dp[l][r] = Math.min(dp[l][r], go(l,i) + go(i+1,r) + (list.get(l).l * list.get(i+1).l * list.get(r).r));
		}
		return dp[l][r];
	}

}