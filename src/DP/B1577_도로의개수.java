package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1577_도로의개수 {

    static int N,M;
    static int K;
    static int[][][] arr;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        dp = new long[N+2][M+2];
        arr = new int[N+2][M+2][2];


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            if(x == x1){//위에서 아래로 가는경우 [][][0] = 1
                arr[x+1][Math.max(y,y1)+1][0] = 1;
            }else //좌에서 우로 가는 경우 [][][1] = 1;
                arr[Math.max(x,x1)+1][y+1][1] = 1;
        }
        dp[1][1] = 1;
        for (int i = 1; i <= N+1; i++) {
            for (int j = 1; j <= M+1; j++) {
             if (arr[i][j][0] != 1) //위에서 아래로 오는게 없으면
                 dp[i][j] += dp[i][j-1];	
             if (arr[i][j][1] != 1) //좌에서 우로 오는게 없으면
                 dp[i][j] += dp[i-1][j]; 

         
            }
          
        }
        bw.write(String.valueOf(dp[N+1][M+1]) + "\n");
        bw.flush();bw.close();
    }

}