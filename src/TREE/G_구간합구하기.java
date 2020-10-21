package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G_구간합구하기 {

	static int N,M;
	static int[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		tree = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			update(i,arr[i]);
		}
		
		/*for (int i = leaf; i < leaf+ N; i++)
			System.out.print(tree[i] + " ");
		System.out.println();
		System.out.println("test : " + sum(1,2));*/
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1){
				System.out.println(sum(c) - sum(b-1));
			}else{
				long dif = c - arr[b];
				arr[b] = c;
				update(b,dif);
			}
		}

	}

	private static long sum(int idx) {
		long result = 0;
		for (int i = idx; i >=1 ; i -= ( i & -i)) {
			result += tree[i];
		}
		return result;
	}

	private static void update(int idx, long dif) {
		// TODO Auto-generated method stub
		for (int i = idx; i < tree.length; i += ( i & -i)) {
			tree[i] += dif;
		}
	}

}