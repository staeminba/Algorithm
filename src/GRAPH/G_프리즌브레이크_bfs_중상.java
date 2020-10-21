package GRAPH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_프리즌브레이크_bfs_중상 {

	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] arr;
	static int[][][] path;
	static final int EXIT = 5;
	static int result;
	static Queue<Edge> q;
	
	static class Edge{
		int x,y,s;
		
		public Edge(int x,int y,int s){
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}
	

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N+1][N+1];
    	path = new int[1<<3][N+1][N+1];
    	q = new LinkedList<>();
    	
    	for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	System.out.println(bfs(new Edge(1,1,0)));
    
    }

	private static int bfs(Edge edge) {
		// TODO Auto-generated method stub
		q.add(edge);
		path[0][1][1] = 1;
		
		while(!q.isEmpty()){
			Edge e = q.poll();
			if(arr[e.x][e.y] == 5){
				return path[e.s][e.x][e.y]; 
			}
			
			int key = e.s;
			for (int i = 0; i < 4; i++) {
				int nx = e.x + dx[i], ny = e.y + dy[i];
				if(1 <= nx && nx <= N && 1 <= ny && ny <= N){
					if(arr[nx][ny] == 1 || 
						(-4 <= arr[nx][ny] && arr[nx][ny] <= -2 && 
						(e.s & (1 << (-arr[nx][ny] - 2))) == 0))	
							continue;
					if(2 <= arr[nx][ny] && arr[nx][ny] <= 4)
						key = e.s | (1 << (arr[nx][ny]-2));
					
					if(-4 <= arr[nx][ny] && arr[nx][ny] <= -2)
						key = e.s & (~(1 << (arr[nx][ny]-2)));
					
					if(path[key][nx][ny] != 0)
						continue;
					
					path[key][nx][ny] = path[e.s][e.x][e.y] + 1;
					q.add(new  Edge(nx,ny,key));
				}
					
			}
		}
		return -1;
	}

}