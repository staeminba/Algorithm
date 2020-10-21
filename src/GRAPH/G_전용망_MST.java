package GRAPH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G_Àü¿ë¸Á_MST {
	static int N;
	static int M;
	static int result;
	static int parent[];
	
	static ArrayList<Edge> list;
	
	static class Edge{
		int a,b,c;
		public Edge(int a, int b,int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    
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
		
		Collections.sort(list,(Edge e,Edge f)-> e.c - f.c);
		
		for (Edge  e : list) {
			int a = find(e.a);
			int b = find(e.b);
			
			if(a==b)
				continue;
			
			parent[b] = a;
			result += e.c;
			
		}
		bw.write(String.valueOf(result));
		bw.close();
    	
    	
	}



	private static int find(int n) {
		// TODO Auto-generated method stub
		if(parent[n] == n)
			return n;
		return parent[n] = find(parent[n]);
	}




}
