package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ������_bfs {
	
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
			while(true) {	//���������� �̵�
				Integer it = chk[0][x].lower(y) == null ? y : chk[0][x].lower(y);	//���������� �̵��� �� �ִ� ���� ����� ���� Ȯ��
				for (int n : chk[0][x]) {
					System.out.print(n + " ");
				}
				System.out.println();
				if (it == chk[0][x].last())
					break;	//�̵��� �� ���� ��� �̵� �ߴ�
				System.out.println(it);
				int ny = it;
				System.out.println("11");
				if (ny - y > K)
					break;	//�̵� �� �� �ִ� �Ÿ�(k)���� �ָ� �ִ� ��� �̵� �ߴ�
				if (sum[1][x][ny] - sum[1][x][y - 1] == 1)
					break;	//�߰��� ��ֹ��� �ִ� ��� �̵� �ش�
				visit(x, ny);	//�ش� ��ġ �湮
				if (dp[x][ny] > dp[x][y] + 1) {	//�ش� ��ġ�� ����� �ð��� ���� �湮�� �ð����� ũ�ٸ� �湮 
					dp[x][ny] = dp[x][y] + 1;
					q.add(new Pos( x, ny));
				}
			}
			while (true) {	//�������� �̵�
				Integer it = chk[0][x].lower(y);
				
				if (it == chk[0][x].first()) break;	//���� �������� �̵��� �� ���� ��� �̵� �ߴ�
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
			while (true) {	//�Ʒ��� �̵�
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
			while (true) {	//���� �̵�
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
