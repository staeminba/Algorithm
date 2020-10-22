package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11400_´ÜÀý¼± {

	static int V,E;
    static ArrayList<Integer>[] list;
    static ArrayList<Edge> edge;
    static int[] cutArr;
    static int[] order;
    static int cnt = 1;
    static int result = 0;

    static class Edge implements Comparable<Edge>{
        int start;
        int dest;

        public Edge(int start,int dest){
            this.start = start;
            this.dest = dest;
        }

        @Override
         public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            if (this.start > o.start) {
                return 1;
            } else if (this.start < o.start) {
                return -1;
            } else {
                return this.dest - o.dest;
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        order = new int[V+1];
        list = new ArrayList[V+1];
        edge = new ArrayList<>();
        cutArr = new int[V+1];



        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= V; i++) {
            if(order[i] == 0)
                dfs(i,1);
        }

        for (int a : cutArr) {
            if(a != 0)
                result++;
        }
        System.out.println(edge.size());
        Collections.sort(edge);
        for (Edge e : edge) {
            System.out.println(e.start + " " + e.dest);
        }

    }

    public static int dfs(int here,int parent){
        order[here] = cnt++;
        int ret = order[here];

        for(int i = 0; i < list[here].size(); i++){
            int next = list[here].get(i);


            if(next == parent)
                continue;

            if(order[next] == 0){
                int low = dfs(next,here);
                //System.out.println(" here : " + here + " next : " + next +   " low : " + low + " order[here] : " + order[here]);
                if(order[here] < low){
                    edge.add(new Edge(Math.min(next,here),Math.max(next,here)));
                }
                //System.out.println("=========11111===========");
                //System.out.println("ret : " + ret + " v : " + here + " order["+next+"] : " + order[next]);
                ret = Math.min(ret,low);
            }else{
                //System.out.println("=========2222===========");
                //System.out.println("ret : " + ret + " v : " + here + " order["+next+"] : " + order[next]);
                ret = Math.min(ret,order[next]);
            }
        }


        return ret;
    }
}