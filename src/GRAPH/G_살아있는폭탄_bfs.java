package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_»ì¾ÆÀÖ´ÂÆøÅº_bfs {
	static int N;
	static int[][] arr;
	static Queue<Edge> q;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int time = 1;
	
	public static class Edge{
		int x,y;
		
		public Edge(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int [N+1][N+1];
    	q = new LinkedList<>();
    	StringTokenizer st;
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 1; j <= N; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			arr[i][j] = num;
    			if(num == 1)
    				q.add(new Edge(i,j));
			}
		}
    	while(!q.isEmpty()){
    		Edge now = q.poll();
    		time = Math.max(time, arr[now.x][now.y]);
    		for (int i = 0; i < 4; i++) {
    			int x = now.x + dx[i];
    			int y = now.y + dy[i];
    			if(x  < 1 || x > N || y < 1 || y > N || arr[x][y] != 0)
    				continue;
    			arr[x][y] = arr[now.x][now.y] + 1;
    			q.add(new Edge(x,y));
			}
    		
    	}
    	System.out.println(time);
    }

}