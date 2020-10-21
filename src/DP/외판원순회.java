package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���ǿ���ȸ {
	
	static int n;
	static int map[][];
	static int[][] dp;
	static final int MAX = 987654321;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	n = Integer.parseInt(br.readLine());
    	map = new int[n][n];
    	dp = new int[n][1<<n];
    	
    	for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	System.out.println(tsp(0,1));
    }

	private static int tsp(int now, int next) {
		// TODO Auto-generated method stub
		//��� ���� �� �������� ����� ���ư�
		if(next == (1<<n) - 1) 
			return map[now][0] != 0 ? map[now][0] : MAX; //now -> next �� �̵� ���� ����
		
		//�Ÿ����� > 0 dp�� ����
		if(dp[now][next] != 0)
			return dp[now][next];
		
		int result = MAX; //dp�� ������ max�� �ʱ�ȭ
		
		for (int i = 0; i < n; i++) {
			if ((next & (1 << i)) > 0) //i��° ������ �湮���� ������
				continue;
			if (map[now][i] == 0) //���� ������ pass
				continue;
			result = Math.min(result, tsp(i, next | (1 << i)) + map[now][i]);
		}
		return dp[now][next] = result;
	}
	
}