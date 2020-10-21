package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_구슬수집가_탐욕법 {
	
	static long N;
	static int K;
	static long[] arr;
  static long result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken()); //개수 
		K = Integer.parseInt(st.nextToken()); //상자의 수
		
		arr = new long[K+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= K; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = K; i >= 1; i--) {
			result += N/arr[i];
			N %= arr[i];
			
		}
		System.out.println(result);
		
	}
}