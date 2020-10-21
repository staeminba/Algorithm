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



public class B1197_MST {

	static int V;
	static int E;
	static int result;
	static int parent[];
	
	static ArrayList<Edge> list;
	
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int weight;
		
		Edge(int v1,int v2,int weight){
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		parent = new int[V+1];
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(a,b,c));
		}
		
		Collections.sort(list);

		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		for (Edge e : list) {
			int a = find(e.v1);
			int b = find(e.v2);
			
			if(a == b)
				continue;
			
			parent[b] = a;
			result += e.weight;
		}
		System.out.println(result);
	}
	
	static int find(int n){
		if(parent[n] == n) 
			return n;
		return parent[n] = find(parent[n]);
	}

	
}
