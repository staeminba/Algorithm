package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class B7578_°øÀå {

	static int N;
	static int[] tree;
	static HashMap<Integer, Integer> map; 
	static long result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[N+1];
		map = new HashMap<Integer, Integer>();
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int a = Integer.parseInt(st.nextToken());
			map.put(a, i);
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int a = Integer.parseInt(st.nextToken());
			int temp = map.get(a);
			update(temp,1);
			result += (sum(N) - sum(temp));
		}
		System.out.println(result);
	}
	
	public static void update(int index,int dif){
		for (int i = index; i <= N; i += (i & -i)) {
			tree[i] += dif;
		}
	}
	
	public static long sum(int index){
		long ans = 0;
		for (int i = index; i > 0; i -= (i & -i)) {
			ans += tree[i];
		}
		return ans;
	}
	
	
}