package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class dfs {
 
	static int[][] graph;
	static boolean visited[];
	static int N;
	static int E;
	static int startPoint;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
        N = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
        
    	visited = new boolean[10001];
    	graph = new int[1001][1001];
        
    	startPoint = Integer.parseInt(st.nextToken());
    	
    	int a,b;
    	for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
	        int index=1;
	        while(st.hasMoreTokens()){
	        	a = Integer.parseInt(st.nextToken());
	        	b = Integer.parseInt(st.nextToken());
	        	graph[a][b] = graph[b][a] = 1;
	        }
		}
    	dfs(startPoint);
    	for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
    	bfs(startPoint);
        
    }

	private static void dfs(int i) {
		// TODO Auto-generated method stub
		visited[i] = true;
		System.out.print(i+" ");
		
		for (int j = 1; j <= N; j++) {
			if(graph[i][j] == 1 && visited[j] == false){
				dfs(j);
			}
		}
		System.out.println();
	}
	
	private static void bfs(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visited[i] = true;
		System.out.print(i+" ");
		
		int temp;
		while(!q.isEmpty()){
			temp = q.poll();
			for (int j = 0; j < N+1; j++) {
				if(graph[temp][j] == 1 && visited[j] == false){
					q.offer(j);
					visited[j] = true;
					System.out.print(j+" ");
				}
			}
		}
	}
    
}

