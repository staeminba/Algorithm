package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 경로찾기_플로이드 {
 

	static int N;
	static int INF = Integer.MAX_VALUE;
	
	static int graph[][];
	static int visit[][];
	static boolean isFirst = false; 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        graph	=	new int[N+1][N+1];
        visit	=	new int[N+1][N+1];
        
        for (int i = 1; i <= N; i++) {
        	st = new  StringTokenizer(br.readLine());
        	for (int j = 1; j <= N; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        		if(graph[i][j] == 0){
        			graph[i][j] = INF;
        		}
        	}
		}
        
//    	floyd();
        for (int i = 1; i <=  N; i++) {
        	dfs(i,i);
        	isFirst = false;
		}
        
        for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.printf("%d ",graph[i][j] == INF ? 0 : 1);
//				System.out.print(graph[i][j]+ " ");
			}
			System.out.println();
		}
    	
    }
    
	private static void dfs(int x,int y) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= N; i++) {
			if(visit[x][i] == 1 || graph[x][i] != 1){
				continue;
			}
			visit[x][i] = 1;
			graph[x][i] = 1;
			dfs(x,i);
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.printf("%d ",graph[i][j] == INF ? 0 : 1);
//				System.out.print(graph[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	private static void floyd() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if(graph[j][i] + graph[i][k] > -1){
						graph[j][k] = Math.min(graph[j][k],graph[j][i] + graph[i][k] );
					}
				}
				
			}
			
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.printf("%d ",graph[i][j] == INF ? 0 : 1);
//				System.out.print(graph[i][j]+ " ");
			}
			System.out.println();
		}
	}

	
}