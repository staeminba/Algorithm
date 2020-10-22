package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B1958_LCS3 {
	static String str1,str2,str3;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        StringTokenizer st;
        br = new BufferedReader(new InputStreamReader(System.in));
        str1 = " " + br.readLine();
        str2 = " " + br.readLine();
        str3 = " " + br.readLine();

        int n1 = str1.length();
        int n2 = str2.length();
        int n3 = str3.length();

        dp = new int[n1][n2][n3];

        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                for (int k = 1; k < n3; k++) {
                    //같으면 좌측 대각선 위의 값 + 1;
                    if (str1.charAt(i) == str2.charAt(j) &&  str1.charAt(i) == str3.charAt(k)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else // 값이 다르면 좌측(x-1), 상단(y-1)의 값중 더 큰 값
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]),dp[i][j][k - 1]);
                }
            }
        }
        System.out.println(dp[n1-1][n2-1][n3-1]);

   /*     String result = "";
        int a = str1.length()-1;
        int b = str2.length()-1;

        while(a >= 1 && b >= 1) {
            if(dp[a][b] == dp[a-1][b])
                a--;
            else if(dp[a][b] == dp[a][b-1])
                b--;
            else {
                result = str1.charAt(a) + result;
                a--;
                b--;
            }
        }
        System.out.println(result);*/
    }

}