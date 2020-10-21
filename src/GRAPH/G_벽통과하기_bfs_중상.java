package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class G_벽통과하기_bfs_중상 {

	static int N;
	static Deque<Edge> dq;
	static int[][] arr;
	static int[][] visit;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	static class Edge{
		int x,y;
		
		public Edge(int x,int y){
			this.x = x;
			this.y = y;
		}
	}

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visit = new int[N+1][N+1];
        dq = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= N; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		arr[i][j] = num;
			}
		}
        bfs();
    }

	private static void bfs() {
		// TODO Auto-generated method stub
		dq.offer(new Edge(1,1));
		visit[1][1] = 1;
		while(!dq.isEmpty()){
		/*	for (Edge e : dq) {
				System.out.println("x : "+ e.x + " y : " + e.y + " w : " + visit[e.x][e.y] );
			}*/
			//System.out.println("========");
			Edge now = dq.pollFirst();
			int x = now.x;
			int y = now.y;
			//System.out.println("x : "+ x + " y : " + y + " w : " + visit[x][y] );
			//System.out.println("88888888888888888");
			if(x == N && y == N){//도착
				System.out.println(visit[x][y]-1);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i] , ny = y+ dy[i];
				if( 1 <= nx && nx <= N
						&& 1 <= ny && ny <= N && visit[nx][ny] == 0){
					if(arr[nx][ny] == 1){
						visit[nx][ny] = visit[x][y];
						dq.addFirst(new Edge(nx,ny));	
					}else{
						visit[nx][ny] = visit[x][y] + 1;
						dq.addLast(new Edge(nx,ny));
					}
				}
			}
		}
		System.out.println("-1");
		return;
	}

}
