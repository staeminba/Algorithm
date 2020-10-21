package GRAPH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_¡¶Ω¿¡¶_bfs {
	static int N;
    static ArrayList<Edge> list;
    static Queue<Edge> q;
    static int[][] arr;
    static int[][] vis;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int res;
    
    static class Edge{
        int x,y,t;
        public Edge(int x,int y,int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        arr = new int[N+1][N+1];
        vis = new int[N+1][N+1];
        q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= N; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		arr[i][j] = num;
        		if(num == 1)
        			list.add(new Edge(i,j,0));
			}
        }
        for (Edge e : list) {
			for (int i = 0; i < 4; i++) {
				int nx = e.x + dx[i], ny = e.y + dy[i];
				if(nx >= 1 && nx <= N 
						&& ny >= 1 && ny <= N 
						&& vis[nx][ny] == 0 && arr[nx][ny] == 0){
					//System.out.println("("+nx+","+ny+") " + arr[nx][ny]);
					arr[e.x][e.y] = 0;
					vis[e.x][e.y] = 1;
					e.t = 1;
					q.add(e);
					break;
				}
			}
		}
      /*  for (Edge e : q) {
        	System.out.println(e.x + " , " + e.y + " " + e.t);
		}*/
        while(!q.isEmpty()){
        	Edge now = q.poll();
        	
        	res = Math.max(res, now.t);
        	for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i], ny = now.y + dy[i], nt = now.t;
				if(nx >= 1 && nx <= N 
						&& ny >= 1 && ny <= N && arr[nx][ny] == 1){
					arr[nx][ny] = 0;
					//System.out.println("nt : " + nt);
					q.add(new Edge(nx,ny,nt+1));
				}
			}
        }
        res = res == 0 ? -1 : res;
        bw.write(res+"\n");
        bw.flush();
        bw.close();
    }


}
