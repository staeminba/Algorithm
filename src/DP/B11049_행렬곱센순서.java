package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B11049_행렬곱센순서 {
	
	static int T;
    static int dp[][];
    static int a[][];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        dp = new int[T + 1][T + 1];
        a = new int[T + 1][2];

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(1, T));
    }

    private static int solve(int start, int end) {
        //System.out.println("start : " + start + " end : " + end + " dp[start][end] : " + dp[start][end]);
        if(dp[start][end] != 0){
            return dp[start][end];
        }
        
        if(start == end){
            return dp[start][end];
        }
        int ret = Integer.MAX_VALUE;
        for (int j = start; j < end; j++) {
            int temp = (solve(start,j) + solve(j+1,end) + (a[start][0] * a[j][1] * a[end][1]));
            //System.out.println("temp : " + temp);
            ret = Math.min(ret, temp);
        }
        //System.out.println("start : " + start + " end : " + end+ " ret : " + ret);
        dp[start][end] = ret;
        return dp[start][end];
    }
}
