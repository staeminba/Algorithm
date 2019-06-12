package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class 적록색약_dfs {
 
	static char[][] graph;
	static char[][] graphRg;
	static boolean visited[][];
	static boolean visitedRg[][];
	static int N;
	
	
	static int dy[]={1,-1,0,0};
	static int dx[]={0,0,1,-1};
	
	static int cnt = 0;
	static int cntRg = 0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
//        System.out.println("N : " + N);

    	
        
    	visited = new boolean[N+1][N+1];
    	visitedRg = new boolean[N+1][N+1];
    	graph = new char[N+1][N+1];
    	graphRg = new char[N+1][N+1];
        
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			char color = (char)br.read();
    			graph[i][j] = color;
    			if(color == 'G'){
    				graphRg[i][j] = 'R';
    			}else{
    				graphRg[i][j] = color;
    			}
    		}
    		br.readLine();
   		}
    /*	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			System.out.print(graphRg[i][j]);
    		}
    		System.out.println();
    	}*/
    	
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			if(visited[i][j] == false){
    				dfs(i,j);
    				cnt++;
    			}
    		}
    	}
    	for (int i = 0; i <= N; i++) {
    		for (int j = 0; j <= N; j++) {
    			visited[i][j] = false;
    		}
    	}
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			if(visitedRg[i][j] == false){
    				dfsRg(i,j);
    				cntRg++;
    			}
    		}
    	}
    	System.out.println(cnt + " " + cntRg);
    	/*for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}*/
    	/*bfs(startPoint);*/
        
    }

	private static void dfs(int x,int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 1 || ny < 1 || nx > N || ny > N || visited[nx][ny]){
				continue;
			}
			if(graph[nx][ny] != graph[x][y]){
				continue;
			}
			dfs(nx,ny);
		}
		
	}
	
	private static void dfsRg(int x,int y) {
		// TODO Auto-generated method stub
		visitedRg[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 1 || ny < 1 || nx > N || ny > N || visitedRg[nx][ny]){
				continue;
			}
			if(graphRg[nx][ny] != graphRg[x][y]){
				continue;
			}
			dfsRg(nx,ny);
		}
		
	}
/*	
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
	}*/
    
}

