package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_타일채우기_중상 {

	static int N;
	static int[][] dp; //[i][j] 현재 위치가 j이고 상태가 i일때 경우의 수
	static int[] arr;
	static final int MOD = (int) (1e9 + 7);
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[4*N + 4];
		dp = new int[(1<<4) + 1][1111];
		
		for (int i = 0; i < 4*N; i+=4) {
			st = new StringTokenizer(br.readLine());
			for (int j = i; j < i+4; j++) {
				arr[j] = Integer.parseInt(st.nextToken());					
			}
		}
		
		for (int i = 0; i < (1<<4); i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		int s = 0;
		for (int i = 0; i < 4; i++) {
			s |= (arr[i] << i);
		}
		
		result = go(0,s);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

	private static int go(int idx, int stat) {
		// TODO Auto-generated method stub
		if(idx == 4*N) //다 돌았으면
			return 1;

		if(dp[stat][idx] != Integer.MAX_VALUE)
			return dp[stat][idx];
		
		dp[stat][idx] = 0;
		stat |= arr[idx];
		
		if((stat & 1) !=0){//현재 위치가타일 못채우면
			dp[stat][idx] = go(idx+1, stat >> 1 | arr[idx+4] << 3);
			dp[stat][idx] %= MOD;
		}else{
			// stat: 4칸을 관리하는 비트마스크, s: 현재 위치, board: 격자판의 정보를 1차원 배열로 저장
			//현재 위치에 타일이 놓여져 있지 않고, 현재 위치가 오른쪽 끝이 아니고, 다음 칸이 비어있는 경우
			//현재 위치를 2로 확인하는 이유는 이전에 이미 첫 번째 칸을 확인했기 때문입니다. 전체 코드에서 확인해주세요.
			if ((stat & 2) == 0 && idx % 4 < 3) {
				//답에 2칸 옮겨서 문제를 해결한 답을 더해줌
				dp[stat][idx] += go(idx + 2, (stat >> 2) | (arr[idx + 4] << 2) | (arr[idx + 5] << 3));
				dp[stat][idx] %= MOD;
			}
			// stat: 4칸을 관리하는 비트마스크, s: 현재 위치, board: 격자판의 정보를 1차원 배열로 저장
			//현재 위치에 타일이 놓여져 있지 않고, 현재 위치가 아래쪽 끝이 아니고, 아래칸이 비어있는 경우
			if (idx / 4 < N - 1 && arr[idx + 4] == 0) {
				//답에 1칸 옮겨서 문제를 해결한 답을 더해줌
				dp[stat][idx] += go(idx + 1, (stat >> 1) | (1 << 3));
				dp[stat][idx] %= MOD;
			}
		}
		return dp[stat][idx];
	}

}