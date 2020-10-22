package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11404_플로이드 {

	static int N,M;
	static int[][] arr;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	M = Integer.parseInt(br.readLine());
    	
    	arr = new int[N+1][N+1];
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			arr[i][j] = i==j ? 0 : 10000001;
    		}
    	}
    	
    	StringTokenizer st;
    	for (int i = 1; i <= M; i++) {
    		st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[s][n] = Math.min(arr[s][n], v); 
		}
    	
    	for (int k = 1; k <= N; k++) {
    		for (int i = 1; i <= N; i++) {
    			for (int j = 1; j <= N; j++) {
    				
    				arr[i][j] =  Math.min(arr[i][j], arr[i][k] + arr[k][j]);
    			}
    		}
		}
    	
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			if(arr[i][j] == 10000001)
    				System.out.print(0 + " ");
    			else
    				System.out.print(arr[i][j] + " ");
    		}
    		System.out.println();
		}
    	
    	
    	
    }


}
