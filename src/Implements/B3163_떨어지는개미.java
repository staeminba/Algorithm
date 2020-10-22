package Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B3163_떨어지는개미 {
	
	private static int N;
	private static int L;
	private static int K;
	private static int[] idx;
	private static List<Ant> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(in.readLine());
			int l = 0;

			StringTokenizer st = null;
			for (int tc = 1; tc <= T; tc++) {
				list.clear();

				st = new StringTokenizer(in.readLine());
				N = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());

				idx = new int[N];

				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(in.readLine());

					l = Integer.parseInt(st.nextToken());
					idx[i] = Integer.parseInt(st.nextToken());

					if (idx[i] > 0)
						list.add(new Ant(L - l, 'R'));
					else
						list.add(new Ant(l, 'L'));
				}

				System.out.println(solve());
			}
		}
	}

	static int solve() {
		int i = 0;

		for (Ant ant : list) {
			if (ant.d == 'L') {
				ant.idx = idx[i++];
			}
		}

		for (Ant ant : list) {
			if (ant.d == 'R') {
				ant.idx = idx[i++];
			}
		}

		Collections.sort(list);

		return list.get(K - 1).idx;
	}

	static class Ant implements Comparable<Ant> {
		int idx;
		int l;
		char d;

		public Ant(int l, char d) {
			
			this.l = l;
			this.d = d;
		}

		@Override
		public int compareTo(Ant o) {
			return this.l == o.l ? this.idx - o.idx : this.l - o.l;
		}
        /*
		@Override
		public String toString() {
			return "Ant [idx=" + idx + ", l=" + l + ", d=" + d + "]";
		}*/
	}
}