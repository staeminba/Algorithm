package GRAPH;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11437_LCA {

	 private static ArrayList<Integer>[] con;
     private static int[] dep;
     private static final int MAX_N = 100000;
     private static final int MAX_D = 17;
     private static int[][] par;
     private static int visit[];
     private static int tmp;
     private static int A;
     private static int B;

     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = null;

         int N = Integer.parseInt(br.readLine().trim());
         par = new int[MAX_D][N + 1];
         con = new ArrayList[N + 1];
         dep = new int[N + 1];
         visit = new int[N + 1];
         for (int i = 1; i <= N; i++) {
             con[i] = new ArrayList<Integer>();
         }
         for (int i = 1; i < N; i++) {
             st = new StringTokenizer(br.readLine().trim());

             A = Integer.parseInt(st.nextToken());
             B = Integer.parseInt(st.nextToken());

             con[A].add(B);
             con[B].add(A);
         }
		/*for (int i = 1; i <= N; i++) {
			dep[i] = -1;
		}*/
         //dfs(1, 0);

         Queue<Integer> que = new LinkedList<>();
         que.add(1);

         while(!que.isEmpty()){
             int q = que.poll();
             visit[q] = 1;
             for(int next : con[q]){
                 if(visit[next] == 0){
                     dep[next] = dep[q] + 1;
                     que.add(next);

                     par[0][next] = q;
                     for (int i = 1; i <= 17 ; i++) {
                         if(par[i - 1][next] == 0) break;
                         par[i][next] = par[i - 1][par[i - 1][next]];
                     }
                 }
             }
         }



         int M = Integer.parseInt(br.readLine().trim());
         for (int i = 1; i <= M; i++) {
             st = new StringTokenizer(br.readLine().trim());

             A = Integer.parseInt(st.nextToken());
             B = Integer.parseInt(st.nextToken());

             //System.out.println("A : " + A + " B : " + B);
             System.out.println(lca(A, B));
         }
     }

     private static void dfs(int node, int depth) {
         if (dep[node] != -1)
             return;

         dep[node] = depth;
         for (int next : con[node]) {
             if (dep[next] != -1)
                 continue;
             par[0][next] = node;
             for (int i = 1; i <= MAX_D; i++) {
                 if (par[i - 1][next] == 0)
                     break;
                 par[i][next] = par[i - 1][par[i - 1][next]];
             }

             dfs(next, depth + 1);
         }
     }

     private static int lca(int a, int b) {
		/*if (dep[a] > dep[b]) {
			tmp = a;
			a = b;
			b = tmp;
		}*/
         //System.out.println("dep[a] : " + dep[a] + " dep[b] : " + dep[b]);
         if (dep[a] > dep[b]) {
             int temp = a;
             a = b;
             b = temp;
         }
         // 깊은 위치에 있는 b를 올리면서 a와 같은 높이를 맞춘다

         for (int i = 17; i >= 0 ; i--) {
             if (((1<<i) & (dep[b] - dep[a])) != 0){
             //if (dep[b] - dep[a] >= (1 << i)){
                 b = par[i][b];
                 //System.out.println("0000000000" + " a : " + a + " b : " + b);
             }
         }
         if(a == b)
             return a;
		/*
		for (int i = MAX_D; i >= 0; i--) {
			if (dep[b] - dep[a] >= (1 << i))
				b = par[i][b];
		}

		if (a == b)
			return a;*/

         for (int i = MAX_D-1; i >= 0; i--) {
             if (par[i][a] != par[i][b]) {
                 a = par[i][a];
                 b = par[i][b];
             }
         }
         //System.out.println("11111111" + " a : " + a + " b : " + b);
         return par[0][a];




         // 공통 조상을 찾는다.
    /* for (int i = 17; i >= 0 ; i--) {
         if(par[i][a] != par[i][b]){
             a = par[i][a];
         	b = par[i][b];
         }
     }

     return par[0][a];*/

     }
 }