package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B4195_模备匙飘况农_MST {

	static int T,F;
	static int N,M;
	static int[] par;
	static int[] cur;
	static int result;
	static ArrayList<Edge> list;
	static HashMap<String, Integer> map;
	
	static class Edge{
		int here;
		int next;
		
		public Edge(int here,int next){
			this.here = here;
			this.next = next;
		}
	}
		

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			F = Integer.parseInt(br.readLine());
			par = new int[F*2+1];
			cur = new int[F*2+1];
			list = new ArrayList<>();
			map = new HashMap<String,Integer>();
			result = 1;
			
			for (int j = 1; j <= F*2; j++) {
				par[j] = j;
				cur[j] = 1;
			}
			
			int temp = 1;
			for (int j = 1; j <= F; j++) {
				st = new StringTokenizer(br.readLine());
				String first = st.nextToken();
				String second = st.nextToken();
				if(!map.containsKey(first)){
					map.put(first, temp);
					temp++;
				}
				if(!map.containsKey(second)){
					map.put(second, temp);
					temp++;
				}
				//System.out.println("first : " + map.get(first) + " second : " + map.get(second));
				int a = find(map.get(first));
				int b = find(map.get(second));
				
				
				//System.out.println(second + " : " + a + " : " + b);
				
				
				if(a==b){
					System.out.println(cur[a]);
					continue;
				}
				par[b] = a;
				cur[a] += cur[b];
				//System.out.println("a : " + a + " b : " + b + " cur[par[a]] : " + cur[par[a]] + " cur[par[b]] : " + cur[par[b]]);
				cur[b] = 1;
				System.out.println(cur[a]);
			}
		}
	}
	
	public static int find(int n){
		if(par[n] == n)
			return n;
		return par[n] = find(par[n]);
	}
	

	
}