package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class B2042_구간합구하기 {
 

	static int N,M,K;
	static long tree[];
	static int arr[];
	static int leaf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		leaf = 1 << (int) Math.ceil(Math.log10(N)/Math.log10(2));
		tree = new long[leaf<<1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init();
		for(int i = 1; i <= M+K; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1){
				update(b,c);
			}else{
				System.out.println(sum(b, c));
			}
		}
		
	}

	public static void init() {
		// TODO Auto-generated method stub
		for (int i = leaf; i < leaf+N; i++) 
			tree[i] = arr[i - leaf + 1];
		for (int i = leaf-1; i > 0; i--) 
			tree[i] = tree[i * 2] + tree[(i*2) + 1];
	}

	public static void update(int idx,int val){
		/*idx += leaf-1;
		tree[idx] = val;
		int dif = (int) (val - tree[idx]);
		while(idx >= 1){
			idx >>= 1;
			tree[idx] += dif;
		}*/
		idx += (leaf-1);
		long diff =  val - tree[idx];
        tree[idx] = val;  // 말단
        while (idx >= 2) {
            idx >>= 1;
            tree[idx] += diff;
        }
		
	}
	
	public static long sum(int left,int right){
		long sum = 0;
		left  += (leaf-1);
		right += (leaf-1);
		while(left <= right){
			if((left&1) != 0 )
				sum += tree[left++];
			if((right & 1) == 0)
				sum += tree[right--];
			left >>= 1;
			right >>= 1;
		}
		if(left == right)
			sum += tree[left];
		
		return sum;
	}
	
	/*public static long init(int start,int end,int node){
		if(start == end)
			return tree[node] = arr[start];
		
		int mid = (start+end)/2;
		
		return tree[node] = init(start,mid,node*2) + init(mid+1,end,node*2+1);
	}
	
	public static void update(int start,int end,int node,int index,int dif){
		if(index < start || end < index)
			return;
		tree[node] += dif;
		
		if(start == end)
			return;
		
		int mid = (start+end)/2;
		update(start,mid,node*2,index,dif);
		update(mid+1,end,node*2+1,index,dif);
	}
	
	public static long sum(int start,int end,int node,int left,int right){
		if(right < start || end < left)
			return 0;
		if(left <= start && end <= right){
			return tree[node];
		}
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right)+sum(mid+1,end,node*2+1,left,right);
		
	}
	*/
}