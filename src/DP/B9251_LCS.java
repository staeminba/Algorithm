package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9251_LCS {

	static String str1,str2;
	static int[][] dp;
    public static void main(String[] args) throws IOException {
    	BufferedReader br;
    	StringTokenizer st;
    	br = new BufferedReader(new InputStreamReader(System.in));
    	str1 = " " + br.readLine();
    	str2 = " " + br.readLine();
    	
    	int n1 = str1.length();
    	int n2 = str2.length();
    	
    	dp = new int[n1][n2];
    	
    	for (int i = 1; i < n1; i++) {
    		for (int j = 1; j < n2; j++) {
    			//������ ���� �밢�� ���� �� + 1;
    			if(str1.charAt(i) == str2.charAt(j))
    				dp[i][j] = dp[i-1][j-1] + 1;
                else // ���� �ٸ��� ����(x-1), ���(y-1)�� ���� �� ū ��
                	dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
			}
		}
    	System.out.println(dp[n1-1][n2-1]);
    
    	
    }
	
}