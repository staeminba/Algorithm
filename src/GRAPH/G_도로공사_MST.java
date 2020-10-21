package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class G_도로공사_MST {

	static class Edge implements Comparable<Edge>{
		int here,next,w;
		
		public Edge(int here,int next,int w){
			this.here = here;
			this.next = next;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		
		
	}
	
	static int V,E;
	static ArrayList<Edge> list;
	static int par[];
	static int res;
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	par = new int[V+1];
    	for (int i = 1; i <= V; i++) {
			par[i] = i;
		}
    	
		list = new ArrayList<>();
    	
    	for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Edge(a,b,c));
		}
    	Collections.sort(list);
    	for (Edge e : list) {
			int a = find(e.here);
			int b = find(e.next);
			
			if(a == b)
				continue;
			
			par[b] = a;
			res += e.w;
			
		}
    	System.out.println(res);
	}
	
	public static int find(int n){
		if(par[n] == n)
			return n;
		
		return par[n] = find(par[n]);
	}


}