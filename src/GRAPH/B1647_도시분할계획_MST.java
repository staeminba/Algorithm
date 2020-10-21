package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1647_도시분할계획_MST {

	static int N,M;
	static int[] par;
	static int result;
	static ArrayList<Edge> list;
	
	static class Edge implements Comparable<Edge>{
		int here;
		int next;
		int weight;
		
		public Edge(int here,int next,int weight){
			this.here = here;
			this.next = next;
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
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		par = new int[N+1];
		
		for (int i = 1; i <=N; i++) {
			par[i] = i;
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(a,b,c));
		}
		
		Collections.sort(list);
		int maxNum = Integer.MIN_VALUE;
		for (Edge e : list) {
			int a = find(e.here);
			int b = find(e.next);
			
			if(a == b)
				continue;
			
			par[b] = a;
			result += e.weight;
			maxNum = Math.max(maxNum, e.weight);
		}
		
		System.out.println(result-maxNum);
	
	}
	
	public static int find(int n){
		if(par[n] == n)
			return n;
		
		return par[n] = find(par[n]);
	}

	
}