package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_ÅÃ¹è¿Õ¾ÈÈ«ÀÚ_TSP {
	
	static int N;
	static int arr[][];
	static int visit[];
	static int order[];
	static int check[];
	static int result;
	static int start;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N + 1][N + 1];
		visit = new int[N + 1];
		order = new int[N + 1];
		check = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] tc = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			tc[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			start = i;
			solve(i,0);
		}

		System.out.println(result);

	}

	private static void solve(int now, int sum) {
		// TODO Auto-generated method stub
		if (now == start && visit[start] == 1) {
			if (result < sum) {
				result = sum;
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visit[i] == 1 || arr[now][i] == 0)
				continue;
			visit[i] = 1;
			solve(i, sum + arr[now][i]);
			visit[i] = 0;
		}

	}

}