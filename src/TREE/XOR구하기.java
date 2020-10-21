package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class XOR±¸ÇÏ±â {
	
	static int N,M;
	static int[] arr,tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		tree = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			update(i,arr[i]);
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(n == 1)
				bw.write(Integer.toString(query(b)^query(a-1))+"\n");
			else{
				int num = arr[a]^b;
				arr[a] = b;
				update(a,num);
			}
				
		}
		bw.flush();bw.close();
	
		
	}
	private static int query(int idx) {
		// TODO Auto-generated method stub
		int result = 0;
		for (int i = idx; i > 0; i -= (i & -i)) {
			result ^= tree[i];
		}
		return result;
	}
	private static void update(int idx, int dif) {
		// TODO Auto-generated method stub
		
		for (int i = idx; i <= N; i += (i & -i)) {
			tree[i] ^= dif;
		}
	}


}
