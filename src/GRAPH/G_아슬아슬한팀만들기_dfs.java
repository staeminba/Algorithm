package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_아슬아슬한팀만들기_dfs {
	static int N,E;
	static ArrayList<Integer>[] list;
	static int[] visit;
	static int[] line;
	static String result = "yes";
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	visit = new int[N+1];
    	line = new int[N+1];
    	list = new ArrayList[N+1];
    	for (int i = 1; i <= N; i++) {
    		list[i] = new ArrayList<>();
		}
    	
    	for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			list[j].add(k);
			list[k].add(j);
		}
    	
    	for (int i = 1; i <= N; i++) {
    		if(visit[i] == 0)
    			dfs(i,1);
		}
    	System.out.println(result);
    }

	private static void dfs(int i,int team) {
		// TODO Auto-generated method stub
		visit[i] = team;
		//System.out.println(i+","+team);
		for (int j = 0; j < list[i].size(); j++) {
			int other = list[i].get(j);
			if(visit[other] == 0){
				int next = visit[i] == 1 ?  2 : 1;
				dfs(other, next);
			}else if(team == visit[other]){
				result = "no";
				return;
			}
			
		}
	}

	

}