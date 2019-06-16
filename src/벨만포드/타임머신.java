package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class 타임머신 {
 
	static int N,M;
	static ArrayList<Edge> list = new ArrayList<Edge>();
	static int[] dist;
	static boolean flag = false;
	
	static class Edge{
		int a,b,c;
		
		Edge(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	dist = new int[N+1];
    	Arrays.fill(dist,Integer.MAX_VALUE);
    	dist[1] = 0;
    	for (int i = 1; i <= M; i++) {
    		st = new StringTokenizer(br.readLine());
    		list.add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
    	
    	bellman();
    	if(flag){
			System.out.println(-1);
		}else{
	    	for (int i = 2; i <= N; i++) {
	    		System.out.println(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
			}
		}
    }

	private static void bellman() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= N; i++) {
			for (Edge g : list) {
				if(dist[g.a] == Integer.MAX_VALUE){
					continue;
				}
				if(dist[g.b] > (dist[g.a] + g.c)){
					dist[g.b] = (dist[g.a] + g.c);
					if (i == N)
                        flag = true;
				} 
			}
		}
	}
}

