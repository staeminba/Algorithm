package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_환상의조합2 {

	static int N;
	static int pref;
	static long dp[][];
	static long result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        pref = 0;
        dp = new long[1<<20][2];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			pref ^= num;
			result += dp[pref][i & 1];
			dp[pref][i & 1]++;
		}
        System.out.println(result);
    }

}