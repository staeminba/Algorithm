package proTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.xml.soap.Node;
 
public class ����� {
 
	static boolean visited[];
	static int[][] road; // ������ ���� 
	static int[][] temp; // ��� �� ���  
	static int[][] floyd; // ��� �� ���  
	static int T; //test ����
	static int N; //������ ��
	static int M; //���� �� 
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
//    	BufferedReader br = new BufferedReader(new FileInputStream(System.in));
    	T = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st;
    	for (int t = 0; t < T; t++) {
    		st = new StringTokenizer(br.readLine()," ");
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		
    		road = new int[N+1][N+1];
    		temp = new int[N+1][N+1];
    		floyd = new int[N+1][N+1];
    		
    		for (int i = 0; i < N + 1; i++) {
    			Arrays.fill(road[i], Integer.MAX_VALUE); 
    			Arrays.fill(floyd[i], Integer.MAX_VALUE); 
			}
    		
    		for (int i = 1; i < M + 1; i++) {
				
    			st = new StringTokenizer(br.readLine(), " ");
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			int cost = Integer.parseInt(st.nextToken());
    			
    			road[x][y] = cost;
			}
    		
    		floyd[1][1] = 0;
    		
    		for (int k = 1; k < N; k++) {
				for (int i = 1; i < N; i++) {
					for (int j = 1; j < N; j++) {
						if(road[i][j] > road[i][k] + road[k][j])
							floyd[i][j] = road[i][k] + road[k][j];
//						floyd[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
					}
				}
			}
    		
    		for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					System.out.print(road[i][j] + " ");
				}
				System.out.println();
			}
    		System.out.println();
    		for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					System.out.print(floyd[i][j] + " ");
				}
				System.out.println();
			}
			
		}
    }

}








