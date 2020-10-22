package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10971_���ǿ���ȸ2_TSP {
	
	static int n;
    static int map[][];
    static int[][] dp;
    static final int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[1<<n][n]; //dp[N][f] -> N���� ���� �ѹ��� �湮�ϰ� f�� ������� ���µ� �ɸ��� �ִ� �ð�

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

        if(next == (1<<n) - 1)//��� ���� �� �������� ����� ���ư�
            return map[now][0] != 0 ? map[now][0] : MAX; //���� �������� �����(0) �� ���� ������


        if(dp[next][now] != 0) //�Ÿ����� ������ dp�� ����
            return dp[next][now];

        int result = MAX;

        for (int i = 0; i < n; i++) { //������� ���鼭
            if ((next & (1 << i)) > 0)  // i�� �湮���� ������
                continue;
            if (map[now][i] == 0) //�̵� �Ұ����ϸ�
                continue;
            result = Math.min(result, tsp(i, next | (1 << i)) + map[now][i]); //i���� �湮 üũ �� �̵�
        }
        return dp[next][now] = result;
    }

}