package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class G_다음타켓 {
static int N;
	
	
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
    	
    	for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			long x1 = Long.parseLong(st.nextToken());
			long y1 = Long.parseLong(st.nextToken());
			long x2 = Long.parseLong(st.nextToken());
			long y2 = Long.parseLong(st.nextToken());
			long x3 = Long.parseLong(st.nextToken());
			long y3 = Long.parseLong(st.nextToken());
			
			Edge a = new Edge(x1,y1); 
			Edge b = new Edge(x2,y2); 
			Edge c = new Edge(x3,y3); 
			
			System.out.println(ccw(a,b,c));
		}
	}
	
	public static int ccw(Edge a, Edge b,Edge c){
		Long result = (a.x*b.y + b.x*c.y + c.x*a.y) - (b.x*a.y + c.x*b.y + a.x*c.y);
		if (result > 0){
            return 1;
        }else if (result < 0){
            return 2;
        }else{
            return 3;
        }
	}



}