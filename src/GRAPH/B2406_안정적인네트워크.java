package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2406_안정적인네트워크 {

	static int N, M;
	static int temp;
	static ArrayList<Edge> eList;
	static int Group[];

	static int TotalCost;
	static ArrayList<Pair> AnsList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		eList = new ArrayList<Edge>();

		Group = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			Group[i] = i;
		}

		int x, y;

		// 최초 연결되어 있는 지사 컴퓨터
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			// 기존에 연결되어 있는 노드끼리는 미리 Union시켜놓음
			Union(x, y);
		}


		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				temp = Integer.parseInt(st.nextToken());

				if (i < j && i > 1 && j > 1) {
					eList.add(new Edge(i, j, temp));
				}
			}
		}


		Collections.sort(eList);

		TotalCost = 0;
		AnsList = new ArrayList<Pair>();

		for (Edge e : eList) {
			if (Find(e.start) != Find(e.end)) {
				TotalCost += e.cost;

				AnsList.add(new Pair(e.start, e.end));

				Union(e.start, e.end);
			}
		}

		System.out.println(TotalCost + " " + AnsList.size());
		for (Pair p : AnsList) {
			System.out.println(p.x + " " + p.y);
		}

	}

	public static void Union(int a, int b) {
		Group[Find(a)] = Find(b);

	}

	public static int Find(int n) {
		if (Group[n] == n)
			return n;

		return Group[n] = Find(Group[n]);
	}

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;

		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			if (this.cost > e.cost)
				return 1;
			else if(this.cost < e.cost)
				return -1;
			else
				return 0;
		}

	}

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}