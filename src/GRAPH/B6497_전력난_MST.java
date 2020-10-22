package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B6497_Àü·Â³­_MST {

	static int n,m;
	static int[] par;
	static long result;
	static long cnt;
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
			if(this.weight - o.weight < 0)
				return -1;
			else if(this.weight - o.weight > 0)
				return 1;
			else 
				return 0;
		}
		
		
	}


    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	while(true){
    		result = 0;
    		cnt = 0;
    		st = new StringTokenizer(br.readLine());
    		
	    	n = Integer.parseInt(st.nextToken());
	    	m = Integer.parseInt(st.nextToken());
	    	
	    	if(n == 0 && m == 0)
	    		return;
	    	par = new int[n];
	    	list = new ArrayList<>();
	    	
	    	for (int i = 0; i < n; i++) {
				par[i] = i;
			}
	    	
	    	for (int i = 1; i <= m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				cnt += c;
				list.add(new Edge(a,b,c));
			}
	    	
	    	Collections.sort(list);
	    	
	    	for (Edge e : list) {
				int a = find(e.here);
				int b = find(e.next);
				if(a==b)
					continue;
				
				par[b] = a;
				result += e.weight;
			}
	    	System.out.println(cnt-result);
    	}
    }


    
    public static int find(int n){
    	if(par[n]==n)
    		return n;
    	return par[n] = find(par[n]);
    }
}