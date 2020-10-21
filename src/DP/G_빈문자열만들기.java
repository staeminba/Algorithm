package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_빈문자열만들기 {

	static char[] msg;
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

		msg = br.readLine().toCharArray();
		dp = new int[msg.length+1][msg.length+1];
		for (int i = 0; i <= msg.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		bw.write(Integer.toString(go(0,msg.length-1))+"\n");

		for (int i = 0; i <= msg.length; i++) {
			for (int j = 0; j <= msg.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		bw.flush();
		bw.close();
	}

	private static int go(int l, int r) {
		// TODO Auto-generated method stub
		if(l > r)
			return 0;
		if(l==r)
			return 1;
		if(dp[l][r] != Integer.MAX_VALUE) //값이 있으면 값 return
			return dp[l][r];
		
		dp[l][r] = 1 + go(l+1,r);//항상 문자열의 시작점을 기준으로 하나의 문자만 나눠지는 경우 abcd (a)(bcd)
		for (int i = l; i <= r; i++) {
			if(msg[l] == msg[i])
				dp[l][r] = Math.min(dp[l][r], go(l+1, i - 1 ) + go(i,r));
		}
		System.out.println(l + " , " + r + " " + dp[l][r]);
		return dp[l][r];
	}

}