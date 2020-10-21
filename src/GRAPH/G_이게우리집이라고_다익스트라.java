package GRAPH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G_이게우리집이라고_다익스트라 {

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
	
	static class Pos implements Comparable<Pos>{
		
		int now;
		int w;
		public Pos(int now,int w){
			
			this.now = now;
			this.w = w;
		}
		@Override
		public int compareTo(Pos o) {
			// TODO Auto-generated method stub
			//return this.w - o.w;
			if(this.w - o.w > 0){
				return 1;
			}else if(this.w - o.w < 0){
				return -1;
			}else{
				return this.now - o.now;
			}
		}
	}
	
	
	static int V,E;
	static int x,t,k;
	static ArrayList<Edge>[] list;
	static ArrayList<Pos> res;
	static int[] dis;
	static int[] stop;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
   
    	list = new ArrayList[V+1];
    	res = new ArrayList<>();
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
    	st = new StringTokenizer(br.readLine());
    	x = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
    	solve(x);
    	
    	
    
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
					q.add(new Edge(e.next,dis[e.next]));
				}
			}
		}
		/*for (int i = 1; i <= V; i++) {
			int res = dis[i];
			bw.write(String.valueOf(res));
			bw.write('\n');
        }
		bw.flush();
		bw.close();*/
		for (int i = 1; i < dis.length; i++) {
			res.add(new Pos(i, dis[i]));
		}
		/*for (Pos t : res) {
			System.out.println(t.now + " : " + t.w);
		}*/
		Collections.sort(res);
		/*System.out.println("---------------------");
		for (Pos t : res) {
			System.out.println(t.now + " : " + t.w);
		}*/

		System.out.println(res.get(k-1).w == 100000000 ? -1 : res.get(k-1).now);
	}

	
}