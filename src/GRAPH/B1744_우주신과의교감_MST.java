package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1744_우주신과의교감_MST {

	static int n,m;
	static int[] par;
	static double result;
	static int[][] arr;
	static ArrayList<Edge> list;
	
	static class Edge implements Comparable<Edge>{
		int here;
		int next;
		double weight;
		
		public Edge(int here,int next,double weight){
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
    	
		st = new StringTokenizer(br.readLine());
		
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	par = new int[n+1];
    	list = new ArrayList<>();
    	arr = new int[n+1][2];
    	
    	for (int i = 1; i <= n; i++) {
			par[i] = i;
		}
    	
    	for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i][0] = x;
			arr[i][1] = y;
		}
    	
    	for (int i = 1; i < n; i++) {
    		for (int j = i+1; j <= n; j++) {
				int maxX = Math.max(arr[i][0], arr[j][0]);
				int minX = Math.min(arr[i][0], arr[j][0]);
				int maxY = Math.max(arr[i][1], arr[j][1]);
				int minY = Math.min(arr[i][1], arr[j][1]);
				double x = (long) Math.pow(maxX-minX, 2);
				double y = (long) Math.pow(maxY-minY, 2);
				double len = Math.sqrt(x+y);
				
				list.add(new Edge(i,j,len));
    		}
		}
    	
    	for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int c = find(a);
			int d = find(b);
			
			if(c==d)
				continue;
			par[d] = c;
		}
    	Collections.sort(list);
    	
    	for (Edge e : list) {
			int a = find(e.here);
			int b = find(e.next);
			if(a==b)
				continue;
			
			par[b] = a;
			//System.out.println(e.here + " , " + e.next + " : " + e.weight);
			result += e.weight;
		}
    	System.out.printf("%.2f\n",result);
    }


    
    public static int find(int n){
    	if(par[n]==n)
    		return n;
    	return par[n] = find(par[n]);
    }
}