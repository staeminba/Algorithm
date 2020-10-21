package bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_환상의조합 {
	
	static class Edge{
		long x,y;
		
		public Edge(long x,long y){
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static ArrayList<Edge> list;
	static Edge result;
	static long Max = Long.MIN_VALUE;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
			
        	st = new StringTokenizer(br.readLine());
        	
        	long x = Long.parseLong(st.nextToken());
        	long y = Long.parseLong(st.nextToken());
        	list.add(new Edge(x,y));
		}
        
        for (int i = 0; i < N-1; i++) {
        	Edge a = list.get(i);
        	for (int j = i+1; j < N; j++) {
        		Edge b = list.get(j);
				long temp = dist(a,b);
				if(temp > Max){
					Max = temp;
					result = new Edge(i+1,j+1);
				}
			}
		}
        System.out.println(result.x + " " + result.y);
              
    }

    public static long dist(Edge a,Edge b) {
		// TODO Auto-generated method stub
    	return (b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y);
    }
}