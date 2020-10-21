package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_¿Í¿ì {
	
	static int N,K;
	static char[] arr;
	static int[][] sum;
	static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        int sz = arr.length;
        sum = new int[2][sz+1];
        
        for (int i = 0; i < arr.length; i++) {
			sum[0][i+1] = sum[0][i];
			sum[1][i+1] = sum[1][i];
			if(arr[i] == 'w')
				++sum[0][i+1];
			else 
				++sum[1][i+1];
		}
        for (int i = 0; i < sz; i++) {
        	  for (int j = i; j < sz; j++) {
        		  result = Math.max(result, sum[0][i] + (sum[1][j] - sum[1][i]) + (sum[0][sz] - sum[0][j]));
        	  }
        }
        System.out.println(result);
    }

}