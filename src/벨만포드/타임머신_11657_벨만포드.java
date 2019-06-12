package 벨만포드;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

 
public class 타임머신_11657_벨만포드 {
	static int T;
	static int dist[];
	static ArrayList<Edge> list;
	static int N;
	static int M;
	static int A,B,C;
	static boolean flag = false;
	
	static class Edge{
		int start;
		int end;
		int time;
		
		public Edge(int start,int end,int time){
			this.start = start;
			this.end = end;
			this.time = time;
		}
		
		public int getStart() {
			return start;
		}
		public int getEnd() {
			return end;
		}
		public int getTime() {
			return time;
		}
	}
 
	// 웜홀은 순환을 하는지 안하는지에 대한 문제
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<Edge>();
			dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[1] = 0;
			
			for (int j = 1; j <= M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				list.add(new Edge(a,b,c));
			}
			bellmanford();
			if(flag){
				System.out.println(-1);
			}else{
				for (int j = 2; j <= N; j++) {
					System.out.println(dist[j] == Integer.MAX_VALUE ? -1 : dist[j]);
				}
			}
		
		
	}
	static void bellmanford(){
		for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
				int s = list.get(j).getStart();
				int e = list.get(j).getEnd();
				int t = list.get(j).getTime();
				if(dist[s] == Integer.MAX_VALUE)
					continue;
				if(dist[e] > dist[s] + t){
					dist[e] = dist[s] + t;
					if (i == N-1)
                        flag = true;
				}
			}
		}
		
	}
}

	
     