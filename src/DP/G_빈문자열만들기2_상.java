package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_빈문자열만들기2_상 {

	static int N;
	static char[] msg;
	static long[][][] dp;
	static ArrayList<Edge> list;
	static long[] arr;
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
		N = Integer.parseInt(br.readLine());
		msg = br.readLine().toCharArray();
		dp = new long[N+1][N+1][N+1];
		arr = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
				
			}
		}
		bw.write(Long.toString(go(0,N-1,1))+"\n");

	/*	for (int i = 0; i <= msg.length; i++) {
			for (int j = 0; j <= msg.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}*/
		bw.flush();
		bw.close();
	}

	private static long go(int l, int r,int pre) {
		// TODO Auto-generated method stub
		/*System.out.println(l + " , " + r + " " + arr[pre]);
		System.out.println(dp[l][r][pre]);*/
		if(l > r)
			return 0;
		if(l==r)
			return arr[pre];
		
		if(dp[l][r][pre] != Integer.MAX_VALUE) //값이 있으면 값 return
			return dp[l][r][pre];
		
		dp[l][r][pre] = arr[pre] + go(l+1,r,1);//항상 문자열의 시작점을 기준으로 하나의 문자만 나눠지는 경우 abcd (a)(bcd)
		for (int i = l+1; i <= r; ++i) {
			if(msg[l] == msg[i])
				dp[l][r][pre] = Math.max(dp[l][r][pre], go(l+1, i - 1,1 ) + go(i,r,pre+1));
		}
		return dp[l][r][pre];
	}

}