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

public class G_경유지_다익스트라 {

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
	static int x,t,k;
	static ArrayList<Edge>[] list;
	static int[] dis;
	static int[] stop;
	static int[][] arr;
	static int result;

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
    	st = new StringTokenizer(br.readLine());
    	x = Integer.parseInt(st.nextToken());
    	t = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
    	
    	if(k == 1){
    		stop = new int[2];
    		st = new StringTokenizer(br.readLine());
	    	for (int i = 0; i < 1; i++) {
	    		stop[i] = Integer.parseInt(st.nextToken());
			}
	    	solve(x);
	    	result += dis[stop[0]];
	    	dis = new int[V+1];
	    	Arrays.fill(dis, 100000000);
	    	solve(stop[0]);
	    	result += dis[t];
	    }else{
	    	stop = new int[2];
	    	arr = new int[3][2];
	    	st = new StringTokenizer(br.readLine());
	    	for (int i = 0; i < 2; i++) {
	    		stop[i] = Integer.parseInt(st.nextToken());
			}
	    	
	    	solve(x);
	    	
	    	arr[0][0] = dis[stop[0]];
	    	arr[0][1] = dis[stop[1]];
	    	
	    	dis = new int[V+1];
	    	Arrays.fill(dis, 100000000);
	    	solve(stop[0]);
	    	arr[1][0] += dis[stop[1]];
	    	arr[1][1] += dis[t];
	    	
	    	dis = new int[V+1];
	    	Arrays.fill(dis, 100000000);
	    	solve(stop[1]);
	    	arr[2][0] += dis[stop[0]];
	    	arr[2][1] += dis[t];
	    	
	    	result = Math.min(arr[0][0] + arr[1][0] + arr[2][1], arr[0][1] + arr[2][0] + arr[1][1]);
	    }
    	System.out.println(result < 100000000 ? result : -1);
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
		/*for (int i = 1; i <= V; i++) {
			int res = dis[i] >= (100000000) ? -1 : dis[i];
			bw.write(String.valueOf(res));
			bw.write('\n');
        }
		bw.flush();
		bw.close();*/
	}

	
}