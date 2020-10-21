package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class G_¹é½Å_bfs {

	static int N,M;
	static ArrayList<Integer>[] list; 
	static int[] arr;
	static int[] visit;
	static int pos,res;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		arr = new int[N+1];
		visit = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
			list[a].add(b);
		}
		
		for (int i = 1; i <= N; i++) {
			bfs(i);
			if(arr[i] > res){
				pos = i;res = arr[i];
			}
		}
		System.out.println(pos + " " + res);
		
		
		
	}

	private static int bfs(int n) {
		// TODO Auto-generated method stub
		
		if(visit[n] == 1)
			return arr[n];
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visit[n] = 1;
		int cnt = 0;
		while(!q.isEmpty()){
			int now = q.poll();
			cnt++;
			for (int i = 0; i <  list[now].size(); i++) {
				int next = list[now].get(i); 
				if(visit[next] == 0){
					visit[next] = 1;
					q.add(next);
				}
			}
		}
		arr[n] = cnt;
		return arr[n];
	}

}
