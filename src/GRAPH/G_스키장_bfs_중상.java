package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_스키장_bfs_중상 {
	static int N,M;
	static int A,B;
	static ArrayList<Edge>[] list;
	static int result;

	static class Edge{
		int next,w;
		
		public Edge(int next,int w){
			this.next = next;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b,c));
		}
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		int r = 1000001 ,  l = 0;
		while(l <= r){
			int mid = (l+r) >> 1;
			//System.out.println(mid + " : " + bfs(mid));
			if(bfs(mid)){
				r = mid-1;
				result = mid;
			}else
				l = mid+1;
			
		}
		System.out.println(result);
		
	}
	private static boolean bfs(int num) {
		// TODO Auto-generated method stub
		Queue<Edge> q = new LinkedList<>();
		boolean[] visit = new boolean[10001];
		visit[A] = true;
		Edge e = new Edge(A, 0);
		q.add(e);
		
		while(!q.isEmpty()){
			Edge now = q.poll();
			if(now.next == B && now.w <= num)
				return true;
			for (Edge n : list[now.next]) {
				if(!visit[n.next] && n.w <= num){
					visit[n.next] = true;
					q.add(n);
				}
			}
		}
		return false;
		/*for (int m : min) {
			System.out.print(m + " ");
		}
		System.out.println();*/
	}

}