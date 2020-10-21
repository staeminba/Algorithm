package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class �ѷ��ڽ��� {
	
	static int T;
	static int L,N,B; // ����,��ǰ����,���
	static ArrayList<Edge>[] list;
	static int W,F,C; // ��ǰ ����,��̵�,���
	static int[][] dp; // i ���� ������ ���� ����� j �϶� �ִ� ��̵�
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
			
			L = Integer.parseInt(st.nextToken()); //���� ��ü ����
			N = Integer.parseInt(st.nextToken()); //��ǰ����
			B = Integer.parseInt(st.nextToken()); //�ִ� ���
			
			
			list = new ArrayList[L+1];
			
			for(int i=0; i<= L; i++)
				list[i] = new ArrayList<>();
			
			for(int i=1; i<= N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				W = Integer.parseInt(st.nextToken()); //��ǰ ����
				F = Integer.parseInt(st.nextToken()); //��ǰ ��̵�
				C = Integer.parseInt(st.nextToken()); //��ǰ ���
				
				list[start].add(new Edge(W,F,C)); //���������� �κ� index�߰�
				
			}
			
			dp = new int[L+1][B+1]; // L���� ������ ���� ����� B �϶� �ִ� ��̵�
			
			/*for(int i=1; i<= L; i++) 
				for(int j=1; j<=B; j++) 
					dp[i][j] = -1; //�ʱ�ȭ
*/			
			dp[0][0] = 0;
			for(int i=0; i<=L; i++) { //
				for(int j=0; j<=B; j++) {
					for(Edge e : list[i]) { //�������� ���� ��ǰ�� ������ش�
						if(j + e.C <= B) { //���� ��뺸�� ��ǰ��븣 ���Ѱ��� �ִ� ������Ͽ��� �Ѵ�.
							if(dp[i+e.W][j+e.C] < dp[i][j] + e.F) //������ + ��ǰ ���� , ���� ��� + ��ǰ ����� ��̵��� < ���� ������, ����� ��̵� + ��ǰ�� ��̵� ���� ������ ��ü 
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
