package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LCA {
	
	static int N;
	static int[] dep,visit;
	static int[][] par;
	static ArrayList<Integer>[] con;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		par = new int[N+1][17];
		dep = new int[N+1];
		visit = new int[N+1];
		con = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			con[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			con[a].add(b);
			con[b].add(a);
		}
		
		Queue<Integer> que = new LinkedList<>();
		que.add(1);

		while (!que.isEmpty()) {
			int q = que.poll();
			visit[q] = 1;
			for (int next : con[q]) {
				if (visit[next] == 0) {
					dep[next] = dep[q] + 1;
					que.add(next);

					par[next][0] = q;
					for (int i = 1; i < 17; i++) {
						if (par[next][i - 1] == 0)
							break;
						par[next][i] = par[par[next][i - 1]][i - 1];

					}
				}
			}
		}
		
		st = new StringTokenizer(br.readLine().trim());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		System.out.println(lca(a, b));
	}
	private static int lca(int a, int b) {
		if (dep[a] > dep[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		// ���� ��ġ�� �ִ� b�� �ø��鼭 a�� ���� ���̸� �����
		for(int i = 16 ; i>=0; i--){
			if(dep[b] - (1<<i) >= dep[a]) //b�� ���̿��� 2�� i������ ������ a���� ũ�ų� ���� ��� 
				b = par[b][i];
		}
		if (a == b)
			return a;

		for (int i = 16; i >= 0; i--) {
			if (par[a][i] != par[b][i]) {
				a = par[a][i];
				b = par[b][i];
			}
		}
		// System.out.println("11111111" + " a : " + a + " b : " + b);
		return par[a][0];
	}
}