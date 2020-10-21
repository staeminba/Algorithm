package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1626_두번째로작은스패닝트리_LCA {

	static int N, M;

    static int result;
    static int parent[];

    static ArrayList<Edge> list;
    static ArrayList<Edge> notLcaList;

    static ArrayList<Edge>[] lcaList;
    private static int[][] par;
    private static int[][] maxArr;
    private static int[][] secondArr;
    private static int visit[];
    private static int[] dep;
    private static final int MAX_D = 19;
    private static int lcaCnt;
    private static int[] maxNum;

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

        list = new ArrayList<>();
        notLcaList = new ArrayList<>();

        lcaList = new ArrayList[N + 1];
        par = new int[MAX_D][N + 1];
        maxArr = new int[MAX_D][N + 1];
        secondArr = new int[MAX_D][N + 1];
        maxNum = new int[2];
        lcaCnt = 0;

        dep = new int[N + 1];
        visit = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lcaList[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i <MAX_D ; i++) {
            for (int j = 0; j <= N ; j++) {
                secondArr[i][j] = Integer.MIN_VALUE;
            }
        }
        parent = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Edge(u, v, w));

        }

        Collections.sort(list);

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (Edge e : list) {
            int a = find(e.v1);
            int b = find(e.v2);

            if (a == b) {
                notLcaList.add(e);
                continue;
            }

            parent[b] = a;
            lcaList[e.v1].add(new Edge(e.v1, e.v2, e.weight));
            lcaList[e.v2].add(new Edge(e.v2, e.v1, e.weight));
            result += e.weight;
            lcaCnt++;
        }
        if (lcaCnt < N - 1) {
            System.out.println("-1");
            return;
        }

        Queue<Edge> que = new LinkedList<>();
        que.add(new Edge(1, 1, 0));

        while (!que.isEmpty()) {
            Edge q = que.poll();
            visit[q.v1] = 1;
            for (Edge e : lcaList[q.v2]) {
                if (visit[e.v2] == 0) {
                    dep[e.v2] = dep[e.v1] + 1;
                    que.add(new Edge(e.v1, e.v2, e.weight));

                    par[0][e.v2] = e.v1;
                    maxArr[0][e.v2] = e.weight;

                    for (int i = 1; i <= MAX_D - 1; i++) {
                        if (par[i - 1][e.v2] == 0) break;
                        par[i][e.v2] = par[i - 1][par[i - 1][e.v2]];
                        maxArr[i][e.v2] = Math.max(maxArr[i - 1][e.v2], maxArr[i - 1][par[i - 1][e.v2]]);
                        secondArr[i][e.v2] = Math.max(Math.min(maxArr[i - 1][e.v2], maxArr[i - 1][par[i - 1][e.v2]]),secondArr[i][e.v2]);
                        //System.out.println(i-1 + " , " + e.next + " minArr[i - 1][e.next] : " + minArr[i - 1][e.next] + " minArr[i - 1][par[i - 1][e.next]] : " + minArr[i - 1][par[i - 1][e.next]]);
                        //System.out.println("maxArr[i - 1][e.next] : " + maxArr[i - 1][e.next] + " maxArr[i - 1][par[i - 1][e.next]] : " + maxArr[i - 1][par[i - 1][e.next]]);

                    }
                }
            }
        }
        //System.out.println("result : " + result);
        int secondNum = Integer.MAX_VALUE;
        //System.out.println("result : " + result);
        boolean flag = false;
        for (Edge e : notLcaList) {
            int temp = result;

            temp += e.weight;
            int a = lca(e.v1, e.v2, e.weight);

            temp -= a;
            //System.out.println(temp + " : " + a + " : " + e.weight + " secondNum : " + secondNum);
            if (temp > result && temp < secondNum) {
                secondNum = temp;
            }


        }
        if (secondNum == result || secondNum == Integer.MAX_VALUE || secondNum < 0)
            System.out.println("-1");
        else
            System.out.println(secondNum);

    }

    private static int lca(int a, int b,int w) {
        int maxResult = Integer.MIN_VALUE;
        int secondResult = Integer.MIN_VALUE;
        if (dep[a] > dep[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        // 깊은 위치에 있는 b를 올리면서 a와 같은 높이를 맞춘다

        for (int i = MAX_D - 1; i >= 0; i--) {

            if (((1 << i) & (dep[b] - dep[a])) != 0) {
                //if (dep[b] - dep[a] >= (1 << i)){
                maxResult = Math.max(maxArr[i][b], maxResult);
                if(maxResult >= w) {
                    secondResult = Math.max(secondArr[i][b], secondResult);
                    maxResult = secondResult;
                }
                //System.out.println(minResult + " " + maxResult);
                b = par[i][b];

            }
        }
        if (a == b) {

            return maxResult;
        }

        // 공통 조상을 찾는다.
        for (int i = MAX_D - 1; i >= 0; i--) {
            //System.out.println(" a : " + a + " b : " + b + " i ; " + i);
            if (par[i][a] != par[i][b]) {
                maxResult = Math.max(Math.max(maxArr[i][a], maxArr[i][b]), maxResult);
                if(maxResult >= w) {
                    secondResult = Math.max(Math.max(secondArr[i][a], secondArr[i][b]), secondResult);
                    maxResult = secondResult;
                }
                a = par[i][a];
                b = par[i][b];
            }

        }
        //System.out.println(maxResult);
        maxResult = Math.max(Math.max(maxArr[0][a], maxArr[0][b]), maxResult);
      /*  if(maxResult >= w) {
            secondResult = Math.max(Math.max(secondArr[0][a], secondArr[0][b]), secondResult);
            maxResult = secondResult;
        }*/
        //System.out.println("11111111" + " a : " + a + " b : " + b);
        //System.out.println("#1 minResult : " + minResult + " maxResult : " + maxResult);
        //System.out.println(maxResult);
        return maxResult;


    }

    static int find(int n) {
        if (parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);
    }


}
