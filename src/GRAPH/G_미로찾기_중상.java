package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_미로찾기_중상 {
	static int N;
    static ArrayList<Edge>[] list;
    static int[][] arr;
    static int[][] visit;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};

    static class Edge{
        int x,y,w;

        public Edge(int x,int y,int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visit = new int[N+1][N+1];
        list = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(num > 1)
                    list[num].add(new Edge(i,j,0));
            }
        }
        bfs();
    }

    private static void bfs() {
        // TODO Auto-generated method stub
        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(1,1,0));
        visit[1][1] = 1;
        while(!q.isEmpty()){
            Edge now = q.poll();
            int x = now.x;
            int y = now.y;
            int w = now.w;
            //System.out.println("x : " + x +  " y : " +y + " arr[x][y] : " + arr[x][y] + " w : " + w +" visit[x][y] : " + visit[x][y]);
            if(x == N && y == N){//도착
                System.out.println(visit[x][y]);
                return;
            }
            boolean chk = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i] , ny = y+ dy[i], num = 0;
                if(1 <= nx && nx <= N && 1 <= ny && ny <= N )
                    num = arr[nx][ny];
                else
                    continue;
                if(num == 1)
                    continue;
                if(!chk && num > 1 && (w & (1<<num)) == 0){
                    for (int j = 0; j < list[num].size(); j++) {
                        nx = list[num].get(j).x;
                        ny = list[num].get(j).y;
                        
                        if(visit[nx][ny] == 0){
                            //System.out.println("nx : " + nx + " ny : " + ny + " num : " + num);
                            visit[nx][ny] = visit[x][y] + 2;
                            //System.out.println("w | (1<<num) : " + (w | (1<<num)));
                            q.add(new Edge(nx,ny,(w | (1<<num))));
                        }
                    }
                    chk = true;
                }
                if((num == 0 || (w & (1<<num))==0) && 1 <= nx && nx <= N
                        && 1 <= ny && ny <= N && visit[nx][ny] == 0){
                    visit[nx][ny] = visit[x][y] + 1;
                    q.add(new Edge(nx,ny,w));
                }
            }


        }
        System.out.println("-1");
        return;
    }

}
