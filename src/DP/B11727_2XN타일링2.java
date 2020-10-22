package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B11727_2XN≈∏¿œ∏µ2 {
	
	static int N;
	static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	System.out.println(solve());
    	
    }
	private static int solve() {
		// TODO Auto-generated method stub
		int[] arr = new int[1001];
		arr[1] = 1;
		arr[2] = 3;
		for (int i = 3; i <= N; i++) {
			arr[i] = (arr[i-1] + arr[i-2]*2)%MOD;
		}
		
		return arr[N];
	}
	
}