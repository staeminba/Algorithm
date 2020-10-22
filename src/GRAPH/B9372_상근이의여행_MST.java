package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9372_상근이의여행_MST {

	static int T;
	static int N,M;
	static int result;
	static int[] par;
	static ArrayList<Edge> list;
	
	static class Edge{
		int here;
		int next;
		
		public Edge(int here,int next){
			this.here = here;
			this.next = next;
		}

		
		
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			par = new int[N+1];
			list = new ArrayList<>();
			result = 0;
			
			for (int j = 1; j <= N; j++) {
				par[j] = j;
			}
			
			for (int j = 1; j <= M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.add(new Edge(a,b));
			}
			
			for (Edge  e : list) {
				int a = find(e.here);
				int b = find(e.next);
				
				if(a==b)
					continue;
				par[b] = a;
				result++;
				
			}
			System.out.println(result);
		}
		
	}


	private static int find(int n) {
		// TODO Auto-generated method stub
		if(par[n] == n)
			return n;
		return par[n] = find(par[n]);
	}
	
		
	

	
}