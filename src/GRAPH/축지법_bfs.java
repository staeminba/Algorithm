package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 축지법_bfs {
	
	static int N,K;
	static int[][] arr,dp;
	static int[][][] sum;
	static TreeSet<Integer>[][] chk;
	
	static class Pos{
		int x,y;
		public Pos(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		sum = new int[2][N+1][N+1];
		chk = new TreeSet[2][N+1];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j <= N; j++) {
				chk[i][j] = new TreeSet<>();
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				chk[0][i].add(j);
				chk[1][j].add(i);
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				
				dp[i][j] = 99999999;
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum[1][i+1][j+1] = sum[1][i+1][j] + arr[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum[0][i+1][j+1] = sum[0][i+1][j] + arr[i][j];
			}
		}
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(1,1));
		visit(1,1);
		dp[1][1] = 0;
		
		while (!q.isEmpty()) {
			int x = q.peek().x, y = q.peek().y;
			q.poll();
			if (x == N && y == N) {
				System.out.println( dp[x][y]);
				return;
			}
			System.out.println(x+","+y);
			while(true) {	//오른쪽으로 이동
				Integer it = chk[0][x].lower(y) == null ? y : chk[0][x].lower(y);	//오른쪽으로 이동할 수 있는 가장 가까운 곳을 확인
				for (int n : chk[0][x]) {
					System.out.print(n + " ");
				}
				System.out.println();
				if (it == chk[0][x].last())
					break;	//이동할 수 없는 경우 이동 중단
				System.out.println(it);
				int ny = it;
				System.out.println("11");
				if (ny - y > K)
					break;	//이동 할 수 있는 거리(k)보다 멀리 있는 경우 이동 중단
				if (sum[1][x][ny] - sum[1][x][y - 1] == 1)
					break;	//중간에 장애물이 있는 경우 이동 준단
				visit(x, ny);	//해당 위치 방문
				if (dp[x][ny] > dp[x][y] + 1) {	//해당 위치에 저장된 시간이 현재 방문한 시간보다 크다면 방문 
					dp[x][ny] = dp[x][y] + 1;
					q.add(new Pos( x, ny));
				}
			}
			while (true) {	//왼쪽으로 이동
				Integer it = chk[0][x].lower(y);
				
				if (it == chk[0][x].first()) break;	//만약 왼쪽으로 이동할 수 없는 경우 이동 중단
				--it;
				int ny = it;
				if (y - ny > K) break;
				if (sum[1][x][y] - sum[1][x][ny - 1] == 1)
					break;
				visit(x, ny);
				if (dp[x][ny] > dp[x][y] + 1) {
					dp[x][ny] = dp[x][y] + 1;
					q.add(new Pos( x, ny ));
				}
			}
			while (true) {	//아래로 이동
				Integer it = chk[1][y].lower(x);
				
				if (it == chk[1][y].last())
					break;
				int nx = it;
				if (nx - x > K) break;
				if (sum[0][nx][y] - sum[0][x - 1][y] == 1)
					break;
				visit(nx, y);
				if (dp[nx][y] > dp[x][y] + 1) {
					dp[nx][y] = dp[x][y] + 1;
					q.add(new Pos(nx, y));
				}
			}
			while (true) {	//위로 이동
				Integer it = chk[1][y].lower(x);
				if (it == chk[1][y].first())
					break;
				--it;
				int nx = it;
				if (x - nx > K)
					break;
				if (sum[0][x][y] - sum[0][nx - 1][y] == 1)
					break;
				visit(nx, y);
				if (dp[nx][y] > dp[x][y] + 1) {
					dp[nx][y] = dp[x][y] + 1;
					q.add(new Pos(nx, y));
				}
			}
		}
	}

	private static void visit(int x, int y) {
		// TODO Auto-generated method stub
		chk[0][x].remove(y);
		chk[1][y].remove(x);
	}

}
