package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_Ÿ��ä���_�߻� {

	static int N;
	static int[][] dp; //[i][j] ���� ��ġ�� j�̰� ���°� i�϶� ����� ��
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
		if(idx == 4*N) //�� ��������
			return 1;

		if(dp[stat][idx] != Integer.MAX_VALUE)
			return dp[stat][idx];
		
		dp[stat][idx] = 0;
		stat |= arr[idx];
		
		if((stat & 1) !=0){//���� ��ġ��Ÿ�� ��ä���
			dp[stat][idx] = go(idx+1, stat >> 1 | arr[idx+4] << 3);
			dp[stat][idx] %= MOD;
		}else{
			// stat: 4ĭ�� �����ϴ� ��Ʈ����ũ, s: ���� ��ġ, board: �������� ������ 1���� �迭�� ����
			//���� ��ġ�� Ÿ���� ������ ���� �ʰ�, ���� ��ġ�� ������ ���� �ƴϰ�, ���� ĭ�� ����ִ� ���
			//���� ��ġ�� 2�� Ȯ���ϴ� ������ ������ �̹� ù ��° ĭ�� Ȯ���߱� �����Դϴ�. ��ü �ڵ忡�� Ȯ�����ּ���.
			if ((stat & 2) == 0 && idx % 4 < 3) {
				//�信 2ĭ �Űܼ� ������ �ذ��� ���� ������
				dp[stat][idx] += go(idx + 2, (stat >> 2) | (arr[idx + 4] << 2) | (arr[idx + 5] << 3));
				dp[stat][idx] %= MOD;
			}
			// stat: 4ĭ�� �����ϴ� ��Ʈ����ũ, s: ���� ��ġ, board: �������� ������ 1���� �迭�� ����
			//���� ��ġ�� Ÿ���� ������ ���� �ʰ�, ���� ��ġ�� �Ʒ��� ���� �ƴϰ�, �Ʒ�ĭ�� ����ִ� ���
			if (idx / 4 < N - 1 && arr[idx + 4] == 0) {
				//�信 1ĭ �Űܼ� ������ �ذ��� ���� ������
				dp[stat][idx] += go(idx + 1, (stat >> 1) | (1 << 3));
				dp[stat][idx] %= MOD;
			}
		}
		return dp[stat][idx];
	}

}