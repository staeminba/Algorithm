package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3176_도로네트워크_LCA {
	
	 private static ArrayList<Edge>[] con;
	    private static int[] dep;
	    private static final int MAX_D = 21;
	    private static int[][] par;
	    private static int[][] minArr;
	    private static int[][] maxArr;
	    private static int visit[];
	    private static int A;
	    private static int B;
	    private static int C;
	    private static int MIN = Integer.MAX_VALUE;
	    private static int MAX = 0;

	    static class Edge{
	        int here;
	        int next;
	        int w;

	        public Edge(int here,int next,int w){
	            this.here = here;
	            this.next = next;
	            this.w = w;
	        }
	    }

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = null;

	        int N = Integer.parseInt(br.readLine());
	        par = new int[MAX_D][N + 1];
	        minArr = new int[MAX_D][N + 1];
	        maxArr = new int[MAX_D][N + 1];

	        con = new ArrayList[N + 1];
	        dep = new int[N + 1];
	        visit = new int[N + 1];

	        for (int i = 1; i <= N; i++) {
	            con[i] = new ArrayList<Edge>();
	        }

	        for (int i = 1; i < N; i++) {
	            st = new StringTokenizer(br.readLine());

	            A = Integer.parseInt(st.nextToken());
	            B = Integer.parseInt(st.nextToken());
	            C = Integer.parseInt(st.nextToken());

	            con[A].add(new Edge(A,B,C));
	            con[B].add(new Edge(B,A,C));
	        }


	        //dfs(1,0);
	        Queue<Edge> que = new LinkedList<>();
	        que.add(new Edge(1,1,0));

	        while (!que.isEmpty()) {
	            Edge q = que.poll();
	            visit[q.here] = 1;
	            for (Edge e : con[q.next]) {
	                if (visit[e.next] == 0) {
	                    dep[e.next] = dep[e.here] + 1;
	                    que.add(new Edge(e.here, e.next, e.w));

	                    par[0][e.next] = e.here;
	                    minArr[0][e.next] = e.w;
	                    maxArr[0][e.next] = e.w;

	                    int minResult = e.w;int maxResult = e.w;

	                    for (int i = 1; i < 17; i++) {
	                        if (par[i - 1][e.next] == 0) break;
	                        par[i][e.next] = par[i - 1][par[i - 1][e.next]];

	                    }
	                }
	            }
	        }

	        for (int h = 1; h <= MAX_D-1; h++) {
	            for (int v = 1; v <= N; v++) {
	                minArr[h][v] = Math.min(minArr[h - 1][v], minArr[h - 1][par[h - 1][v]]);
	                maxArr[h][v] = Math.max(maxArr[h - 1][v], maxArr[h - 1][par[h - 1][v]]);
	                par[h][v] = par[h - 1][par[h - 1][v]];
	            }
	        }



	        int M = Integer.parseInt(br.readLine());
	        for (int i = 1; i <= M; i++) {
	            st = new StringTokenizer(br.readLine());

	            A = Integer.parseInt(st.nextToken());
	            B = Integer.parseInt(st.nextToken());

	            lca(A, B);
	        }
	    }

	    private static void dfs(int u, int h) {
	        visit[u] = 1;
	        dep[u] = h;

	        for (Edge v : con[u]) {
	            if (visit[v.next] == 0) {
	                minArr[0][v.next] = v.w;
	                maxArr[0][v.next] = v.w;
	                par[0][v.next] = u;
	                dfs(v.next, h + 1);
	            }
	        }
	    }

	    private static void lca(int a, int b) {
	        int minResult = Integer.MAX_VALUE;int maxResult = Integer.MIN_VALUE;
	        if (dep[a] > dep[b]) {
	            int temp = a;
	            a = b;
	            b = temp;
	        }
	        // 깊은 위치에 있는 b를 올리면서 a와 같은 높이를 맞춘다

	        for (int i = MAX_D-1; i >= 0; i--) {

	            if (((1 << i) & (dep[b] - dep[a])) != 0) {
	                //if (dep[b] - dep[a] >= (1 << i)){
	                minResult = Math.min(minArr[i][b], minResult);
	                maxResult = Math.max(maxArr[i][b], maxResult);
	                b = par[i][b];

	            }
	        }
	        if (a == b) {

	            System.out.println(minResult + " " + maxResult);
	            return;
	        }

	        // 공통 조상을 찾는다.
	        for (int i = MAX_D-1; i >= 0; i--) {
	            if (par[i][a] != par[i][b]) {
	                minResult = Math.min(Math.min(minArr[i][a],minArr[i][b]), minResult);
	                maxResult = Math.max(Math.max(maxArr[i][a],maxArr[i][b]), maxResult);
	                a = par[i][a];
	                b = par[i][b];
	            }

	        }
	        minResult =  Math.min(Math.min(minArr[0][a],minArr[0][b]), minResult);
	        maxResult = Math.max(Math.max(maxArr[0][a],maxArr[0][b]), maxResult);
	        System.out.println(minResult + " " + maxResult);

	        return;


	    }
	}