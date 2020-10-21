package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_난전설같은건믿지않아 {
	
	static int N;
	static int K;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        solve(N,1,K);
        System.out.println(sb);
    }

	private static void solve(int pil,int now, int goal) {
		// TODO Auto-generated method stub
		if(pil == 0)
			return;
		int next = 6 - (now + goal);
		solve(pil - 1, now , next);
		sb.append(pil + " " + goal+"\n");
		solve(pil - 1, next ,goal);
		
	}

}