package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2294_µ¿Àü2 {

	static int n;
	static int k;
	static int cnt[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n > 100 || n < 1)
        	return;
        if(k > 10000 || k < 1)
        	return;
		cnt = new int[k+1];
		Arrays.fill(cnt,999999999);
		for (int i = 1; i <= n; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > 100000)
        		n = 0;
			add(n);
			
		}
		
		System.out.println(cnt[k] == 999999999 ? -1 : cnt[k]);
	}

	private static void add(int n2) {
		// TODO Auto-generated method stub
		cnt[0] = 0;
		for (int j = n2; j <= k ; j++) {
			cnt[j] = Math.min(cnt[j], cnt[j-n2] + 1);
			//System.out.print(cnt[j] + " ");
		}
		//System.out.println();
	}
}