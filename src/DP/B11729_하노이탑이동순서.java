package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B11729_하노이탑이동순서 {
	
	static int N;
	static int K;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        solve(N,1,3);
        sb.insert(0,cnt + "\n");
        System.out.println(sb);
    }

	private static void solve(int pil,int now, int goal) {
		// TODO Auto-generated method stub
		if(pil == 0)
			return;
		cnt++;
		int next = 6 - (now + goal);
		solve(pil - 1, now , next);
		sb.append(now + " " + goal+"\n");
		solve(pil - 1, next ,goal);
		
	}
}