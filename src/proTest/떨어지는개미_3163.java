package proTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 떨어지는개미_3163 {
	private static int N;
	private static int L;
	private static int K;
	private static int[] idx;
	private static List<Ant> list = new ArrayList<>();
	
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
       
	}

	public static void main(String[] args) throws Exception {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(in.readLine());
			String p = "";

			StringTokenizer st = null;
			for (int tc = 1; tc <= T; tc++) {
				list.clear();

				st = new StringTokenizer(in.readLine());
				N = Integer.parseInt(st.nextToken());	//개미수
				L = Integer.parseInt(st.nextToken());	//막대길이
				K = Integer.parseInt(st.nextToken());	//K번째 떨어지는 수

				idx = new int[N];

				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(in.readLine());

					idx[i] = Integer.parseInt(st.nextToken());	//ID
					p = st.nextToken();		//방향

					if ("R".equals(p))
						list.add(new Ant(L - idx[i], 'R'));
					else
						list.add(new Ant(idx[i], 'L'));
				}
				for (Ant ant : list) {
					System.out.print(ant.idx + " " + ant.l + " " + ant.d);
					System.out.println();
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
		System.out.println("=========================");
		for (Ant ant : list) {
			System.out.print(ant.idx + " " + ant.l + " " + ant.d);
			System.out.println();
		}
		for (Ant ant : list) {
			if (ant.d == 'R') {
				ant.idx = idx[i++];
			}
		}
		System.out.println("=========================");
		for (Ant ant : list) {
			System.out.print(ant.idx + " " + ant.l + " " + ant.d);
			System.out.println();
		}
		Collections.sort(list);
		System.out.println("=========================");
		for (Ant ant : list) {
			System.out.print(ant.idx + " " + ant.l + " " + ant.d);
			System.out.println();
		}
		return list.get(K - 1).idx;
	}
}

