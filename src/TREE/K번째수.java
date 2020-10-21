package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class K¹øÂ°¼ö {
	
	static int N;
	static int leaf;
	static int[] arr;
	static long[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		leaf = 1 << (int)Math.ceil(Math.log10(1000000)/Math.log10(2));
		tree = new long[leaf << 1 + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			if(n == 1){
				int pos = query(a) - leaf + 1;
				bw.write(pos+"\n");
			}else{
				long b = Long.parseLong(st.nextToken());
				update(a,b);
			}
				
		}
		bw.flush();bw.close();
	
		
	}
	private static int query(long val) {
		// TODO Auto-generated method stub
		int idx = 1;
		while(idx < leaf){
			if(tree[idx<<1] >= val){
				idx <<= 1;
			}else{
				val -= tree[idx<<1];
				idx = (idx<<1) + 1;
			}
			tree[idx]--;
		}
		//System.out.println("idx : " + idx);
		return idx;
	}
	private static void update(int idx, long dif) {
		// TODO Auto-generated method stub
		
		idx += (leaf-1);
		tree[idx] += dif;
		while(idx >= 2){
			idx >>= 1;
			tree[idx] += dif;
		}
	}


}
