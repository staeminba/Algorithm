package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class B1922_네트워크연결_MST {
 

	static int N;
	static int M;
	static int result;
	static int parent[];
	
	static ArrayList<Edge> list;
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int c;
		
		Edge(int a,int b,int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.c - o.c;
		}
		
		
		
		
	}
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		list = new ArrayList<>();
		parent = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Edge(a,b,c));
		}
		
		Collections.sort(list);
		
		for (Edge e : list) {
			int a = find(e.a);
			int b = find(e.b);
			
			if(a == b)
				continue;
			parent[b] = a;
			result += e.c;
		}
		
		System.out.println(result);
	}
	
	public static int find(int n){
		if(parent[n] == n)
			return n;
		
		return parent[n] = find(parent[n]);
	}
	
	

	
}