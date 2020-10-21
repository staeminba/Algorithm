package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_성격테스트_LCS {
	
	static char[] str1,str2;
	static int[][] dp;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	String str = br.readLine();
    	str1 = new char[str.length()+1];
    	for (int i = 1; i < str1.length; i++) {
			str1[i] = str.charAt(i-1);
		}
    	str = br.readLine();
    	str2 = new char[str.length()+1];
    	for (int i = 1; i < str2.length; i++) {
			str2[i] = str.charAt(i-1);
		}
    	
    	dp = new int[str1.length][str2.length];
    	
    	lcs();
    	bw.write(dp[str1.length-1][str2.length-1]+"\n");
		

    	bw.flush();bw.close();
    }

    private static void lcs() {
		// TODO Auto-generated method stub
    	for (int i = 0; i < str1.length; i++) {
    		dp[i][0] = i;
    	}
    	for (int i = 0; i < str2.length; i++) {
    		dp[0][i] = i;
    	}
    	for (int i = 1; i < str1.length; i++) {
    		for (int j = 1; j < str2.length; j++) {
    			if(str1[i] == str2[j])
    				dp[i][j] = dp[i-1][j-1];
    			else
    				dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
    		}
			
		}
	}
	
}