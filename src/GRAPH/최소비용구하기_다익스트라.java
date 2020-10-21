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

public class 최소비용구하기_다익스트라 {

	static int T;
	static int x;
	static int n;
	static ArrayList<Edge> list;
	static int end;

	static class Edge implements Comparable<Edge> {
		int value;

		Edge(int value) {
			this.value = value;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.value - e.value;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			x = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			list = new ArrayList();
			for (int j = 1; j <= n; j++) {
				list.add(new Edge(Integer.parseInt(br.readLine())));
			}
			Collections.sort(list);
			solve(x, list);

		}

	}

	private static void solve(int xt, ArrayList<Edge> list2) {
		System.out.println("list2 : " + list2.size());
		for (int i = 0; i < n; i++) {
			for (int j = n-1; j > 0; j--) {
				if(i== j || i > j){
					System.out.println("없다");
					return;
				}
				System.out.println(list2.get(i).value  + " + " + list2.get(j).value +" = " + (list2.get(i).value + list2.get(j).value));
				if ((list2.get(i).value + list2.get(j).value) > xt * 10000000) {
					continue;
				} else if ((list2.get(i).value + list2.get(j).value) < xt * 10000000) {
					i++;
				} else {
					System.out.println("#" + T + " " + list2.get(i).value + " "
							+ list2.get(j).value);
					return;
				}
			}

		}
	}
}
