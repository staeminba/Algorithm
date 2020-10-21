package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
 
public class B1275_Ä¿ÇÇ¼ó2 {
 

	static int N,Q;
	static long tree[];
	static long arr[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		tree = new long[N*4];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1,N,1);
		
		for (int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x < y)
				System.out.println(sum(1,N,1,x,y));
			else
				System.out.println(sum(1,N,1,y,x));
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			update(1,N,1,a,b-arr[a]);
			arr[a] = b;
			
		}
	}
	
	static long init(int start,int end,int node){
		if(start == end)
			return tree[node] = arr[start];
		int mid = (start+end)/2;
		return tree[node] = init(start,mid,node*2) + init(mid+1,end,node*2+1);
		
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
