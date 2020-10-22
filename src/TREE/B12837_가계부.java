package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class B12837_°¡°èºÎ {
 
	static int N,Q;
	static long tree[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		tree = new long[N*4];
		
		
		for (int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1){
				update(1,N,1,b,c);
			}else if(a == 2){
				System.out.println(sum(1,N,1,b,c));
			}
		}
	}
	
	static void update(int start,int end,int node,int index,long dif){
		if(index < start || index > end){
			return;
		}
		tree[node] += dif;
		if(start == end)
			return;
		int mid = (start+end)/2;
		update(start,mid,node*2,index,dif);
		update(mid+1,end,node*2+1,index,dif);
	}
	
	static long sum(int start,int end,int node, int left,int right){
		if(right < start || end < left)
			return 0;
		if(left <= start && end <= right)
			return tree[node];
		
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right) + sum(mid+1,end,node*2+1,left,right);
	}
	
	
   
  

}