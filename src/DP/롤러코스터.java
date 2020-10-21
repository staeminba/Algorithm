package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 롤러코스터 {
	
	static int T;
	static int L,N,B; // 길이,부품개수,비용
	static ArrayList<Edge>[] list;
	static int W,F,C; // 부품 길이,재미도,비용
	static int[][] dp; // i 까지 지었고 들인 비용이 j 일때 최대 재미도
	static int result;
	
	static class Edge{
		int W,F,C;
		
		public Edge(int W,int F,int C){
			this.W = W;
			this.F = F;
			this.C = C;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
				
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken()); //레일 전체 길이
			N = Integer.parseInt(st.nextToken()); //부품개수
			B = Integer.parseInt(st.nextToken()); //최대 비용
			
			
			list = new ArrayList[L+1];
			
			for(int i=0; i<= L; i++)
				list[i] = new ArrayList<>();
			
			for(int i=1; i<= N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				W = Integer.parseInt(st.nextToken()); //부품 길이
				F = Integer.parseInt(st.nextToken()); //부품 재미도
				C = Integer.parseInt(st.nextToken()); //부품 비용
				
				list[start].add(new Edge(W,F,C)); //시작점기준 부붐 index추가
				
			}
			
			dp = new int[L+1][B+1]; // L까지 지었고 들인 비용이 B 일때 최대 재미도
			
			/*for(int i=1; i<= L; i++) 
				for(int j=1; j<=B; j++) 
					dp[i][j] = -1; //초기화
*/			
			dp[0][0] = 0;
			for(int i=0; i<=L; i++) { //
				for(int j=0; j<=B; j++) {
					for(Edge e : list[i]) { //시작점이 같은 부품만 계산해준다
						if(j + e.C <= B) { //현재 비용보다 부품비용르 더한값이 최대 비용이하여하 한다.
							if(dp[i+e.W][j+e.C] < dp[i][j] + e.F) //시작점 + 부품 길이 , 현재 비용 + 부품 비용의 재미도가 < 현재 시작점, 비용의 재미도 + 부품의 재미도 보다 작으면 교체 
								dp[i+e.W][j+e.C] = dp[i][j] + e.F;
						}
					}
				}
			}
			
//			for(int i=0; i<=L; i++) {
//				for(int j=0; j<=B; j++) {
//					System.out.print(D[i][j] + " ");
//				}
//				System.out.println();
//			}
			result = 0;
			for(int i=0; i<B+1; i++){ 
				if(result < dp[L][i]) 
					result = dp[L][i];
			}
			
			bw.write("#"+t+" " + (result == 0 ? -1 : result)  + "\n");
		}
		bw.flush();bw.close();
		
		
	}
	
}
