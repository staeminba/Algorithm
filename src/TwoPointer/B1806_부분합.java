package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1806_ºÎºÐÇÕ {
	
	static int N,S;
	static int start,end,sum,length;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		length = Integer.MAX_VALUE;
		solve();
		if(length == Integer.MAX_VALUE){
			System.out.println(0);
		}else{
			System.out.println(length);
		}
	}

	private static void solve() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N*2; i++) {
			if(sum >= S){
				length = Math.min(length, end-start);
				sum -= arr[start];
				start++;
			}else{
				if(end == N){
					break;
				}
				sum += arr[end];
				end++;
			}
		}
	}

	
}

