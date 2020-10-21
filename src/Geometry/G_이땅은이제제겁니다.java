package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class G_이땅은이제제겁니다 {
	static int N;
	static ArrayList<Edge> list;
	static double result;
	
	
	static class Edge{
		long x,y;
		
		public Edge(long x, long y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	list = new ArrayList<>();
    	for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			
			list.add(new Edge(x,y)); 
			
		}
    	
    	Edge e = list.get(0);
    	
    	for (int i = 1; i < N-1; i++) {
			result += ccw(list.get(i),list.get(i+1),e);
			
		}
    	System.out.println(Math.round(Math.abs(result/2)));
	}
	
	public static int ccw(Edge a, Edge b,Edge c){
		return (int) ((a.x*b.y+b.x*c.y+c.x*a.y) - (b.x*a.y + c.x*b.y + a.x*c.y));
	}



}