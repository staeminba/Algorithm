package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2887_행성터널_MST {

	static int N;
	static int result;
	static int[] par;
	static int[][][] arr;
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

	static class Point implements Comparable<Point>{
		int point;
		int loc;
		
		public Point(int point,int loc){
			this.point = point;
			this.loc = loc;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.point - o.point;
		}
	}

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	
    	N = Integer.parseInt(br.readLine());
    	
    	par = new int[N+1];
    	list = new ArrayList<>();
    	ArrayList<Point> x = new  ArrayList<>();
    	ArrayList<Point> y = new  ArrayList<>();
    	ArrayList<Point> z = new  ArrayList<>();
    	/*Point[] x = new Point[N+1];
    	Point[] y = new Point[N+1];
    	Point[] z = new Point[N+1];*/
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int xP = Integer.parseInt(st.nextToken());
    		int yP = Integer.parseInt(st.nextToken());
    		int zP = Integer.parseInt(st.nextToken());
    		
    		x.add(new Point(xP,i+1));
    		y.add(new Point(yP,i+1));
    		z.add(new Point(zP,i+1));
    		/*y[i] = new Point(yP,i+1);
    		z[i] = new Point(zP,i+1);*/
		}
    	Collections.sort(x);
    	Collections.sort(y);
    	Collections.sort(z);
    	/*Arrays.sort(x);
    	Arrays.sort(y);
    	Arrays.sort(z);*/
    	
    	for (int i = 1; i <= N; i++) {
			par[i] = i;
		}
    	
    	for (int i = 0; i < N-1; i++) {
    		
			list.add(new Edge(x.get(i).loc,x.get(i+1).loc,Math.abs(x.get(i).point - x.get(i+1).point)));
			list.add(new Edge(y.get(i).loc,y.get(i+1).loc,Math.abs(y.get(i).point - y.get(i+1).point)));
			list.add(new Edge(z.get(i).loc,z.get(i+1).loc,Math.abs(z.get(i).point - z.get(i+1).point)));
		}
    	Collections.sort(list);
    	for (Edge e : list) {
    		int a = find(e.here);
    		int b = find(e.next);
    		
    		if(a==b)
    			continue;
    		
    		par[b] = a;
    		//System.out.println(e.here + " : " + e.next + " : " + e.weight);
    		result += e.weight;
			
		}
    	System.out.println(result);
    	
    }


	private static int find(int n) {
		// TODO Auto-generated method stub
		if(par[n] == n)
			return n;
		return par[n] = find(par[n]);
	}


}