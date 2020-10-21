package GRAPH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G_학교지도만들기_다익스트라 {

static class Edge implements Comparable<Edge>{
		
		int next;
		int w;
		public Edge(int next,int w){
			
			this.next = next;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
	static int V,E;
	static int N;
	static ArrayList<Edge>[] list;
	static int[] dis;

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
   
    	list = new ArrayList[V+1];
    	dis = new int[V+1];
    	Arrays.fill(dis, 100000000);
    	for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
    	
    	for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[x].add(new Edge(y,w));
			list[y].add(new Edge(x,w));
		}
    	
    	N = Integer.parseInt(br.readLine());
    	solve(N);
    	
    }

	private static void solve(int n) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(n,0));
		dis[n] = 0;
		
		while(!q.isEmpty()){
			Edge now = q.poll();
		
			for (Edge e : list[now.next]) {
				
				if(dis[e.next] > e.w + dis[now.next]){
					dis[e.next] = e.w + dis[now.next];
					q.offer(new Edge(e.next, dis[e.next]));
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			int res = dis[i] >= (100000000) ? -1 : dis[i];
			bw.write(String.valueOf(res));
			bw.write('\n');
        }
		bw.flush();
		bw.close();
	}

	
}