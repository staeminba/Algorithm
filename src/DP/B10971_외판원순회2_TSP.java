package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10971_외판원순회2_TSP {
	
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
        dp = new int[1<<n][n]; //dp[N][f] -> N개의 나라를 한번씩 방문하고 f번 나라까지 가는데 걸리는 최단 시간

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

        if(next == (1<<n) - 1)//모든 정점 다 돌았으면 출발점 돌아감
            return map[now][0] != 0 ? map[now][0] : MAX; //현재 지역에서 출발지(0) 로 갈수 있으면


        if(dp[next][now] != 0) //거리값이 있으면 dp값 리턴
            return dp[next][now];

        int result = MAX;

        for (int i = 0; i < n; i++) { //모든지역 돌면서
            if ((next & (1 << i)) > 0)  // i점 방문한적 있으면
                continue;
            if (map[now][i] == 0) //이동 불가능하면
                continue;
            result = Math.min(result, tsp(i, next | (1 << i)) + map[now][i]); //i번쨰 방문 체크 후 이동
        }
        return dp[next][now] = result;
    }

}