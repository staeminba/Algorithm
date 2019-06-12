package º§¸¸Æ÷µå;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CopyOf¿úÈ¦_1865_º§¸¸Æ÷µå {
	
	static class Edge{
		int start,next,val;
		
		Edge(int s,int e, int t){
			this.start = s;
			this.next = e;
			this.val = t;
		}
	}
	
	static int T,N,M,W;
	static ArrayList<Edge> list;
	static int[] dist;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			list = new ArrayList<Edge>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[1] = 0;
			
			for (int j = 1; j <= M+W; j++) {
				st = new StringTokenizer(br.readLine());
				int s,e,t;
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				if(j > M){
					list.add(new Edge(s,e,t*-1));
				}else{
					list.add(new Edge(s,e,t));
					list.add(new Edge(e,s,t));
				}
			}
			
			if(bellman()){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

	private static boolean bellman() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= N; i++) {
			for (Edge e: list) {
				if(dist[e.start] == Integer.MAX_VALUE){
					continue;
				}else if(dist[e.next] > dist[e.start] + e.val){
					if(i == N){
						return true;
					}
					dist[e.next] = dist[e.start] + e.val;
				}
			}
		}
		return false;
	}
}