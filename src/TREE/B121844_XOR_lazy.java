package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class B121844_XOR_lazy {
 
	static int n,m;
	static int arr[];
	static int t,a,b,c;
	static long tree[];
	static long lazy[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		arr = new int[n];
		tree = new long[n*4];
		lazy = new long[n*4];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(0,n-1,1);
		m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			a = b = c  = 0;
			if(t == 1){
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				if(a <= b)
					update_lazy(0,n-1,1,a,b,c);
				else
					update_lazy(0,n-1,1,b,a,c);
			}else{
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(a<=b)
					System.out.println(query(0,n-1,1,a,b));
				else
					System.out.println(query(0,n-1,1,b,a));
					
			}
			
		}
	}
	
	public static long init(int start,int end,int node){
		if(start == end)
			return tree[node] = arr[start];
		
		int mid = (start+end)/2;
		return tree[node] = init(start,mid,node*2) ^ init(mid+1,end,node*2+1);
	}
	
	public static void update_lazy(int start,int end,int node,int left,int right,int dif){
		if(lazy[node] != 0)
			propagation(start,end,node);
		if(right < start || end < left)
			return;
		if(left <= start && end <= right){
			tree[node] ^= ((end-start+1)%2)*dif;
			if(start != end){
				lazy[node*2] ^= dif;
				lazy[node*2+1] ^= dif;
			}
			return;
		}
		
		int mid = (start+ end)/2;
		update_lazy(start,mid,node*2,left,right,dif);
		update_lazy(mid+1,end,node*2+1,left,right,dif);
		
		tree[node] = tree[node*2] ^ tree[node*2+1];
		
	}
	
	public static long query(int start,int end,int node,int left,int right){
		if(lazy[node]!=0)
			propagation(start, end, node);
		if(right < start || end < left)
			return 0;
		if(left <= start && end <= right){
			return tree[node];
		}
		int mid = (start + end)/2;
		return query(start,mid,node*2,left,right) ^ query(mid+1,end,node*2+1,left,right);
	
	}
	
	public static void propagation(int start,int end,int node){
		tree[node] ^= ((end-start+1)%2)*lazy[node];
		if(start != end){
			lazy[node*2] ^= lazy[node];
			lazy[node*2+1] ^= lazy[node];
		}
		lazy[node] = 0;
	}
}