package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G_ºÎ¾÷ÀÇ´ÞÀÎ_Å½¿å¹ý {
	
	static class Edge implements Comparable<Edge>{
		int start,end;
		public Edge(int start,int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.end - o.end;
		}
	}
	static int N;
	static ArrayList<Edge> list;
	static int result;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	list.add(new  Edge(s,e));
		}
        Collections.sort(list);
        solve();
        System.out.println(result);
    }

	private static void solve() {
		// TODO Auto-generated method stub
		Edge now = list.get(0);
		result++;
		for (Edge e : list) {
			if(now.end <= e.start){
				now = e;
				result++;
			}
			
		}
	}

}