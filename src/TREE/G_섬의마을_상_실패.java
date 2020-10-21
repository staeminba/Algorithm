package TREE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_섬의마을_상_실패 {

	static int N, M;
	static int[] arr;
	static long[] tree;
	static int leaf;
	static long result;
	static ArrayList<Edge> list;
	
	static class Edge{
		int s,e;
		
		public Edge(int s,int e){
			this.s = s;
			this.e = e;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int sz = 5000000;
		leaf = 1 << (int)Math.ceil(Math.log10(sz)/Math.log10(2));
		tree = new long[leaf<<1];
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Edge(s,e));
		}
			
		list.sort((Edge e1,Edge e2) -> e2.s - e1.s);
		
		long result = 0;
		for (Edge e : list) {
			update(e.s,1);
			result = Math.max(result, sum(e.s,e.e));
		}
		System.out.println(result);
		

	}

	public static long sum(int left,int right){
		int sum = 0;
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

	private static void update(int idx, int val) {
		// TODO Auto-generated method stub
		idx += (leaf-1);
		tree[idx] = val;
		while(idx > 1){
			idx >>= 1;
			tree[idx] += val;
		}
	}

}