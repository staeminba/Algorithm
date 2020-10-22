package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16991_외판원순회3_TSP {
	
	static int n;
	static double map[][];
	static int city[][];
	static double[][] dp;
	static final double MAX = 987654321;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	n = Integer.parseInt(br.readLine());
    	map = new double[n][n];
    	dp = new double[n][1<<n];
    	city = new int[n][2];
    	
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < 2; j++) {
    			city[i][j] = Integer.parseInt(st.nextToken());
    		}
		}
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==j)
					continue;
				int x1 = city[i][0];
				int y1 = city[i][1];
				int x2 = city[j][0];
				int y2 = city[j][1];
				map[i][j] = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
			}
		}
    	
    	System.out.println(tsp(0,1));
    }

	private static double tsp(int now, int next) {
		// TODO Auto-generated method stub
		//모든 정점 다 돌았으면 출발점 돌아감
		if(next == (1<<n) - 1)
			return map[now][0] != 0 ? map[now][0] : MAX;
		
		//거리값이 > 0 dp값 리턴
		if(dp[now][next] != 0)
			return dp[now][next];
		
		double result = 987654321;
		
		for (int i = 0; i < n; i++) {
			if ((next & (1 << i)) > 0)
				continue;
			if (map[now][i] == 0)
				continue;
			result = Math.min(result, tsp(i, next | (1 << i)) + map[now][i]);
		}
		return dp[now][next] = result;
	}
	
}