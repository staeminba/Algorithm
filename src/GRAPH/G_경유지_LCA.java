package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_°æÀ¯Áö_LCA {

	static int N;
	static int[] dep, visit;
	static int[][] par;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		dep = new int[N + 1];
		visit = new int[N + 1];
		par = new int[N + 1][17];
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		init();
		int M = Integer.parseInt(br.readLine());

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int temp = lca(a, b);
			if ((lca(a, c) == c && lca(a, b) == temp)
					|| (lca(b, c) == c && lca(a, c) == temp))
				System.out.println("1");
			else
				System.out.println("0");

		}

	}

	private static int lca(int a, int b) {
		// TODO Auto-generated method stub
		if (dep[a] > dep[b]) {
			int temp = a;
			a = b;
			b = temp;
		}

		for (int i = 16; i >= 0; i--) {
			if (dep[b] - (1 << i) >= dep[a])
				b = par[b][i];

		}
		if (a == b) {
			return a;
		}

		for (int i = 16; i >= 0; i--) {
			if (par[a][i] != par[b][i]) {
				a = par[a][i];
				b = par[b][i];
			}
		}
		// System.out.println("11111111" + " a : " + a + " b : " + b);
		return par[a][0];
	}

	private static void init() {
		// TODO Auto-generated method stub
		Queue<Integer> que = new LinkedList<>();
		que.add(1);

		while (!que.isEmpty()) {
			int now = que.poll();
			visit[now] = 1;
			for (int next : list[now]) {
				if (visit[next] == 0) {
					dep[next] = dep[now] + 1;
					que.add(next);
					par[next][0] = now;

					for (int i = 1; i < 17; i++) {
						if (par[next][i - 1] == 0)
							break;
						par[next][i] = par[par[next][i - 1]][i - 1];
					}
				}
			}
		}
	}
}
