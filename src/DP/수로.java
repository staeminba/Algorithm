package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수로 {

	static int N;
	static int[][] dp, arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static final int MOD = (int) (1e9 + 7);
	static int result;

	// dp[i][j] = (i,j)에서 출발하여 (N,N)까지 도착하는 경로의 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 2][N + 2];
		dp = new int[N + 2][N + 2];
		result = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i <= N+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = N; i > 0; i--) {
			for (int j = N; j > 0; j--) {
				if (j == N && i == N)
					continue;
				dp[i][j] = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (dp[nx][ny] != -1 && arr[i][j] > arr[nx][ny]) {
						System.out.println("11 " + i+","+j + " - > " + nx+","+ny + " dp[nx][ny]: " + dp[nx][ny]);
						dp[i][j] += dp[nx][ny];
						continue;
					}
					// 다음 위치에 방문할 수 있는 경우
					if (1 <= nx && nx <= N && 1 <= ny && ny <= N
							&& arr[i][j] > arr[nx][ny]) {
						System.out.println(i+","+j + " -> "+nx+","+ny + " dp[nx][ny]  : " + dp[nx][ny] );
						if(dp[nx][ny] == -1){
							dp[nx][ny] = 1;
						}
						dp[i][j] += dp[nx][ny];
						System.out.println(dp[i][j]);
						dp[i][j] %= MOD;
					}

				}
			}
		}

		// bw.write(go(1,1)+"\n");
		for (int i1 = 1; i1 <= N; i1++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(dp[i1][j] + " ");
			}
			System.out.println();
		}

		bw.write(dp[1][1]);
		bw.flush();
		bw.close();
	}

	private static int go(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println(x + "," + y);
		if (x == N && y == N)
			return 1;
		else {
			if (dp[x][y] != -1)
				return dp[x][y];

			dp[x][y] = 0;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 다음 위치에 방문할 수 있는 경우
				if (1 <= nx && nx <= N && 1 <= ny && ny <= N
						&& arr[x][y] > arr[nx][ny]) {
					int temp = go(nx, ny);
					dp[x][y] += temp;
					System.out.println(x + "," + y + " : " + temp);
					dp[x][y] %= MOD;
				}
			}
		}

		return dp[x][y];
	}

}