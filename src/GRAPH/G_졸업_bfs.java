package GRAPH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class G_Á¹¾÷_bfs {
 
	static int N,M,C;
	static ArrayList<Integer>[] list;
	static int[] visit;
	static int result;
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	list = new ArrayList[N+1];
    	visit = new int[N+1];
    	
    	for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
    	
    	for (int i = 1; i <= M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
		}
    	
    	C = Integer.parseInt(br.readLine());
    	bfs(C);
    	System.out.println(result);
	}

	private static void bfs(int n) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		while(!q.isEmpty()){
			result++;
			int now = q.poll();
			visit[now] = 1;
			//System.out.println("now : " + now + " : " + list[now].get(0));
			for (int i : list[now]) {
				if(visit[i] == 0)
					q.add(i);
			}
		}
	}


}
	