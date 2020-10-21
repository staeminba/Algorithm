package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class G_친구네트워크_플로이드 {
 
	static int V,E,Q;
	static int x,t,k;
	static int[] dis;
	static int[][] arr;
	

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	Q = Integer.parseInt(st.nextToken());
    	
    	arr = new int[V+1][V+1];
    	for (int i = 1; i <= V; i++) {
    		for (int j = 1; j <= V; j++) {
    			if(i == j)
    				arr[i][j] = 0;
    			else
    				arr[i][j] = 100000000;
    		}
    	}
    	
    	
    	for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = Math.min(arr[x][y], 1);
		}
    	
    	
    	
    	for (int i = 1; i <= V; i++) {
    		for (int j = 1; j <= V; j++) {
				for (int k = 1; k <= V; k++) {
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
				}
			}
			
		}
    	for (int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(arr[x][y] < 100000000 ? 1 : 0);
		}
    
    }


}