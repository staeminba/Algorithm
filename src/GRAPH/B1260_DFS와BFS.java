package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class B1260_DFS¿ÍBFS {
 
	static int[][] graph;
	static boolean visited[];

	static int N;
	static int M;
	static int startNum;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startNum = Integer.parseInt(st.nextToken());
        
    	visited = new boolean[N+1];

    	graph = new int[N+1][N+1];
    	
    	for (int i = 1; i <= M; i++) {
    			st = new StringTokenizer(br.readLine());
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			graph[a][b] = graph[b][a] = 1;
   		}
    	
		dfs(startNum);
		System.out.println();
		
		for (int i = 1; i <= N; i++) {
			visited[i] = false;
		}
		bfs(startNum);
		
    	
    }

	private static void dfs(int s) {
		// TODO Auto-generated method stub
		visited[s] = true;
		
		System.out.print(s + " ");
		
		for (int i = 1; i <= N; i++) {
			if(visited[i] || graph[s][i] != 1){
				continue;
			}
			dfs(i);
		}
	}
	
	private static void bfs(int s) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[s] = true;
		q.offer(s);
		
		while(!q.isEmpty()){
			int here = q.poll();
			
			System.out.print(here + " ");
			
			for (int i = 1; i <= N; i++) {
				if(visited[i] || graph[here][i] != 1){
					continue;
				}
				visited[i] = true;
				q.offer(i);
			}
		}
	}
}