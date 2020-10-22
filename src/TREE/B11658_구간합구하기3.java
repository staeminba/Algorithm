package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class B11658_구간합구하기3 {
 
	
	static int tree[][];
	static int N,M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		tree = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken()); 
				update(i,j,temp);
			}
		}
		
		for(int i = 1; i<=M; i++){
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			if(w == 0){
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int def = sum(x,y) - sum(x-1,y) - sum(x,y-1) + sum(x-1,y-1);
				update(x,y,c - def);
			}else if(w == 1){
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int sum = sum(x2,y2) - sum(x1-1,y2) - sum(x2,y1-1) + sum(x1-1,y1-1);
				System.out.println(sum);
			}
			
		}
	}
	
	public static int sum(int x, int y){
		int  ans = 0;
		for (int i = x; i > 0; i -= (i&-i)) {
	        for (int j = y; j > 0; j -= (j&-j)) {
	            ans += tree[i][j];
	        }
	    }
	    return ans;
	}
	
	public static void update(int x,int y,int dif){
		for (int i = x; i <= N; i += (i & - i)) {
	        for (int j = y; j <= N; j += (j & -j)) {
	            tree[i][j] += dif;
	        }
	    }
	}
}