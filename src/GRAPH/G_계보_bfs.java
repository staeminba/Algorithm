package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class G_°èº¸_bfs {
 
	static int N;
	static ArrayList<Integer>[] list;
	static int[] res;
	static int[] visit;
	static Queue<Integer> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new
		// OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		res = new int[N+1];
		visit = new int[N+1];
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			list[now].add(next);
			list[next].add(now);
		}
		
		bfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(res[i]);
		}
		
	}

	private static void bfs(int i) {
		// TODO Auto-generated method stub
		q = new LinkedList<>();
		visit[i] = 1;
		q.add(1);
		while(!q.isEmpty()){
			int now = q.poll();
			for (int e : list[now]) {
				if(visit[e] == 0){
					res[e] = now;
					q.add(e);
					visit[e] = 1;
				}
			}
			
		}
		
	}

}