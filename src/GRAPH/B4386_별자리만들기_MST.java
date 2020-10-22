package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B4386_별자리만들기_MST {

	static int N;
    static int par[];
    static float result;
    static float arr[][];
    static ArrayList<Edge> list;




    static class Edge  implements Comparable<Edge>{
        int v1;
        int v2;
        float weight;

        Edge(int v1, int v2, float weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return (int)(this.weight - o.weight);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        par = new int[N+1];
        arr = new float[N+1][2];
        list = new ArrayList<>();
        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            float a = Float.parseFloat(st.nextToken());
            float b = Float.parseFloat(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        for (int i = 1; i <= N ; i++) {
            par[i] = i;
        }

        for (int i = 1; i <= N ; i++) {
            for (int j = i+1; j <= N ; j++) {
                float maxX = Math.max(arr[j][0],arr[i][0]);
                float minX = Math.min(arr[j][0],arr[i][0]);
                float maxY = Math.max(arr[j][1],arr[i][1]);
                float minY = Math.min(arr[j][1],arr[i][1]);
                float weight = (float)Math.sqrt((maxX - minX)*(maxX - minX) + (maxY - minY)*(maxY - minY));
                list.add(new Edge(i,j,weight));
            }
        }


        Collections.sort(list);

        for(Edge e : list){
            int a = find(e.v1);
            int b = find(e.v2);

            if(a==b)
                continue;

            par[b] = a;
            result += e.weight;
        }
        System.out.printf("%.2f\n",result);


    }

    static int find(int n) {
        if (par[n] == n)
            return n;
        return par[n] = find(par[n]);
    }


}
