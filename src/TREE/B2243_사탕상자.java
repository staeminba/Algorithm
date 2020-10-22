package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class B2243_ªÁ≈¡ªÛ¿⁄ {
 
	static final int Max = 1000000;
	static int n;
	static int a,b;
	static long c;
	
	static long tree[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		tree = new long[Max*4];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a == 1){
				int temp = query(1,Max,1,b);
				System.out.println(temp);
				update(1,Max,1,temp,-1);
			}else if(a == 2){
				c = Integer.parseInt(st.nextToken());
				update(1,Max,1,b,c);
			}
		}
		

	}
	
	public static int query(int start,int end,int node,int index){
		if(start == end)
			return start;
		
		int mid = (start+end)/2;
		
		if(tree[node*2] >= index)
			return query(start,mid,node*2,index);
		else{
			index -= tree[node*2];
			return query(mid+1,end,node*2+1,index);
		}
		
	}

	public static void update(int start,int end,int node,int index,long dif){
		if(index < start || end < index)
			return;
		
		tree[node] += dif;
		if(start == end)
			return;
		int mid = (start+end)/2;
		update(start,mid,node*2,index,dif);
		update(mid+1,end,node*2+1,index,dif);
	}
}