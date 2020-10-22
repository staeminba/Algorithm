package MATH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16395_ÆÄ½ºÄ®ÀÇ»ï°¢Çü {
	static int N,R;
    static int dp[][];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dp = new int[N+1][N+1];
        dp[1][1] = 1;
        for (int i = 2; i <= N ; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= i ; j++) {
                if(i==j)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][R]);
    }
}
