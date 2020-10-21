package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_∫∞µÈ¿«¿¸¿Ô {

	static int N,K;
    static int[] arr;
    static int[] dp;
    static final int MAX = 98765432; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        dp = new int[10001];

        Arrays.fill(dp,MAX);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] <= 10000)
                dp[arr[i]] = 1;
        }
        Arrays.sort(arr);

        for (int i = 1; i <= K; ++i)
            for (int j = 1; j <= N && arr[j] <= i; j++){
            	//System.out.println(" i : " + i + " j : " + j + " arr[j] : " + arr[j] + " " + dp[i] + " dp[i - arr[j]] + 1 : " + (dp[i - arr[j]] + 1));
                dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
           }
        System.out.println(dp[K] == MAX ? -1 : dp[K]);


    }
}