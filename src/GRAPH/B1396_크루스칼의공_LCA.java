package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1396_크루스칼의공_LCA {

	static int N, M, Q;

    static int result;
    static int parent[];
    static int size[]; //갯수
    private static int[] maxNum;

    static PriorityQueue<Edge> q;
    static ArrayList<Edge> notLcaList;

    public static ArrayList<Edge>[] lcaList;
    private static int[][] par;
    private static int[][] maxArr;
    private static int[][] secondArr;
    private static int visit[];
    private static int[] dep;
    private static final int MAX_D = 19;
    private static int lcaCnt;
    

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int weight;

        Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return (int) (this.weight - o.weight);
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        q = new PriorityQueue();

        lcaList = new ArrayList[N + M + 1];
        par = new int[N + M + 1][MAX_D];
        
        lcaCnt = 0;

        dep = new int[N + M + 1];
        visit = new int[N + M + 1];




        parent = new int[N + M + 1];
        size = new int[N + M +  1];
        maxNum  = new int[N + M +  1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            q.add(new Edge(u, v, w));

        }


        for (int i = 1; i <= N+M; i++) {
        	lcaList[i] = new ArrayList<>();
            parent[i] = i;
            size[i] = 1;
        }

        int start = N+1;
        while(!q.isEmpty()){
        	Edge e = q.poll();
        	int a = e.v1;
            int b = e.v2;
            int w = e.weight;

            int fir = find(a);
            int sec = find(b);
            if(fir == sec)
                continue;
            size[start] = size[fir] + size[sec];
            //System.out.println("a : " + a + " b : " + b + " i : " + i + " fir : " + fir + " sec : " + sec);
            maxNum[start] = w;
            lcaList[fir].add(new Edge(fir, start, w));
            lcaList[start].add(new Edge(start, fir, w));
            lcaList[sec].add(new Edge(sec, start, w));
            lcaList[start].add(new Edge(start, sec, w));
            parent[fir] = start;
            parent[sec] = start;
            start++;
            lcaCnt++;
        }

               
        for (int i = N+M; i > N; i--) {
        	 Queue<Edge> que = new LinkedList<>();
        	 que.add(new Edge(i, i, 0));
        	 
        	 while(!que.isEmpty()){
        		 Edge q = que.poll();
        		 visit[q.v1] = 1;
        		 for (Edge e : lcaList[q.v2]) {
					if(visit[e.v2] == 0){
						dep[e.v2] = dep[e.v1] + 1;
						que.add(e);
						
						par[e.v2][0] = e.v1;
						for (int j = 1; j <= MAX_D; j++) {
							if(par[e.v2][j-1] == 0)
								break;
							par[e.v2][j] = par[par[e.v2][j-1]][j-1];
							
						}
					}
				}
        	 }
			
		}
       
        Q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= Q; i++) {
        	st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int num = lca(a,b);
			if(find(a) != find(b))
				System.out.println("-1");
			else 
				System.out.println(maxNum[num] + " " + size[num]);
			
		}

    }

    

    private static int lca(int a, int b) {
		// TODO Auto-generated method stub
    	if(dep[a] > dep[b]){
    		int temp = a;
    		a = b;
    		b = temp;
    	}
    	
    	//깊은 위치에 있는 b를 같은 위치로 맞춰 준다
    	for (int i = 16; i >= 0; i--) {
			if(((1<<i) & (dep[b] - dep[a])) != 0){
				b = par[b][i];
			}
		}
    	
    	if(a==b)
    		return a;
    	
    	//같은 위치면 공통 조상 찾아준다
    	for (int i = 16; i >= 0; i--) {
    		if(par[b][i] != par[a][i]){
    			a = par[a][i];
    			b = par[b][i];
    		}
    	}
		return par[a][0];
	}



	static int find(int n) {
        if (parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);
    }


}