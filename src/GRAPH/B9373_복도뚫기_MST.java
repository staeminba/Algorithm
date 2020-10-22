package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9373_º¹µµ¶Õ±â_MST {

	static int T;
    static int W,N;
    static int par[],rank[];
    static double result;
    static ArrayList<Edge> list;
    static ArrayList<Edge> comp;

    static class Edge {
        int v1;
        int v2;
        double weight;

        Edge(int v1, int v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T ; i++) {
            W = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());

            par = new int[N + 2];
            rank = new int[N + 2];
            list = new ArrayList<>();
            comp = new ArrayList<>();

            for (int j = 0; j < N ; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                comp.add(new Edge(a,b,c));
            }

            for (int j = 0; j < N+2 ; j++) {
                par[j] = j;
                rank[j] = 1;
            }

            list.add(new Edge(N,N+1,W));
            for (int j = 0; j < comp.size() ; j++) {
                Edge c = comp.get(j);
                double leftW = Math.max(0,c.v1- c.weight);
                double rightW = Math.max(0,W-(c.v1 + c.weight));
                list.add(new Edge(j,N,leftW));
                list.add(new  Edge(j,N+1,rightW));

                for (int k = 0; k < j ; k++) {
                    if(k == j)
                        continue;
                    Edge m = comp.get(k);
                    double weight = Math.sqrt(Math.pow(c.v1 - m.v1,2) + Math.pow(c.v2 - m.v2,2));
                    weight = weight - c.weight - m.weight;
                    list.add(new Edge(k,j,weight));
                }
            }

            Collections.sort(list, (Edge a, Edge b)-> a.weight >= b.weight  ? 1 : -1);
            for(Edge e : list){
                int a = find(e.v1);
                int b = find(e.v2);


                if(a==b)
                    continue;
                if(rank[a] < rank[b]){
                    par[a] = b;

                }else{
                    par[b] = a;
                    if(rank[a] == rank[b]){
                        rank[a]++;
                    }
                }
                if(find(N) == find(N+1)) {
                    result = e.weight;

                    break;
                }

            }
            if(result < 1)
                System.out.println("0");
            else
                System.out.println(result/2);
        }
    }

    static int find(int n) {
        if (par[n] == n)
            return n;
        return par[n] = find(par[n]);
    }


}