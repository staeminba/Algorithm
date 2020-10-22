package GRAPH;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

 
public class B10026_적록색약_bfs {
	static char[][] graph;
	static char[][] graphRg;
	static boolean visited[][];

	static int N;
	
	
	static int dx[]={0,0,1,-1};
	static int dy[]={1,-1,0,0};
	
	static int cnt = 0;
	static int cntRg = 0;
	
	static class Node{
		int x,y;
		Node(int x,int y){
			this.x = x;
			this.y = y;
		}
		
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
    	visited = new boolean[N+1][N+1];

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
    	
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			if(visited[i][j] == false){
    				bfs(i,j);
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
    			if(visited[i][j] == false){
    				bfsRg(i,j);
    				cntRg++;
    			}
    		}
    	}
    	System.out.println(cnt + " " + cntRg);
        
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
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 1 || ny < 1 || nx > N || ny > N || visited[nx][ny]){
				continue;
			}
			if(graphRg[nx][ny] != graphRg[x][y]){
				continue;
			}
			dfsRg(nx,ny);
		}
		
	}
	
	private static void bfs(int x,int y) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x,y));
		visited[x][y] = true;
		
		Node temp;
		
		while(!q.isEmpty()){
			temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx < 1 || ny < 1 || nx > N || ny > N || visited[nx][ny]){
					continue;
				}
				if(graph[nx][ny] != graph[x][y]){
					continue;
				}
				q.offer(new Node(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	private static void bfsRg(int x,int y) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x,y));
		visited[x][y] = true;
		
		Node temp;
		
		while(!q.isEmpty()){
			temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx < 1 || ny < 1 || nx > N || ny > N || visited[nx][ny]){
					continue;
				}
				if(graphRg[nx][ny] != graphRg[x][y]){
					continue;
				}
				q.offer(new Node(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}
}