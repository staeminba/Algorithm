package MATH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16922_로마숫자_순열 {
	static int M, N;
	static boolean[] visit;
	static int[] num;
	static int[] input;
	static StringBuilder sb;
	static int sum[] = new int[1001];
	static int temp;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		M = Integer.parseInt(st.nextToken());
		num = new int[M + 1];
		input = new int[] { 0, 1, 5, 10, 50 };
		visit = new boolean[4 + 1];
		Arrays.fill(visit, false);
		perm(0, 0);
		// System.out.println(sb.toString());
		System.out.println(result);

	}

	public static void perm(int r, int temp) {
		// System.out.println("r : " + r);
		if (r == M) {

			if (sum[temp] == 0) {
				sum[temp] = temp;
				result++;
			}
			return;
		} else {
			for (int i = 1; i <= 4; i++) {

				// visit[i] = true;
				if (num[r] > input[i])
					continue;
				num[r + 1] = input[i];
				perm(r + 1, temp + input[i]);
				// System.out.println("r+!");
			}
		}
	}
}