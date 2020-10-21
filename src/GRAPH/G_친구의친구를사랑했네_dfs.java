package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_친구의친구를사랑했네_dfs {
	static int N,E;
	static ArrayList<Integer>[] list;
	static int[] visit;
	static int result = 0;
	static int num = 0;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	
    	list = new ArrayList[N+1];
    	for (int i = 1; i <= N; i++) {
    		list[i] = new ArrayList<>();
		}
    	
    	for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			list[j].add(k);
		}
    	
    	for (int i = 1; i <= N; i++) {
    		visit = new int[N+1];
    		int sum = dfs(i,1);
    		if(result < sum){
    			result = sum;
    			num = i;
    		}
    		
		}
    	System.out.println(num);
    }

	private static int dfs(int i, int cnt) {
		// TODO Auto-generated method stub
		
		visit[i] = 1;
		//System.out.println(i+","+cnt);
		int temp = 1;
		for (int j = 0; j < list[i].size(); j++) {
			int next = list[i].get(j);
			if(visit[next] == 0){
				temp += dfs(next,cnt+1);
				//System.out.println(i+","+next + " , " + cnt);
			}
		}
		return temp;
	}

	

}