package MATH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13251_조약돌꺼내기 {
	static int N,M,K;
    static int[] color;
    static double[] arr;
    static double[][] dp;
    static double result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        color = new int[M];
        arr = new double[M];
        dp = new double[2501][2501];
        pascal();
        //System.out.printf("%.18f\n",dp[100][50]);
        //System.out.println(dp[100][50]);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M ; i++) {
            color[i] = Integer.parseInt(st.nextToken());
            N += color[i];
        }
        K = Integer.parseInt(br.readLine());

        double mo = dp[N][K];
        double ja = 0;
        for (int i = 0; i < M; i++) {
            ja += dp[color[i]][K];
        }

        result = ja/mo;
        System.out.println(result);

    }

    public static void pascal(){
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <=2500; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;

            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }
}