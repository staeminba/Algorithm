package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
 
public class B2517_´Þ¸®±â {
 
	static int N;
    static int arr[];
    static int tree[];
    static int cnt[];
    static ArrayList<Edge> list;
    static Edge[] sort;
    public static class Edge implements Comparable<Edge>{
        int num = 0;
        int pos = 0;

        public Edge(int num,int pos){
            this.num = num;
            this.pos = pos;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return o.num - this.num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        //list = new Edge[N];
        list = new ArrayList<>();
        tree = new int[N+1];
        cnt = new int[N+1];
        // StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            Edge e = new Edge(num,i);
            list.add(e);
			/*list[i].num = num;
			list[i].pos = i;*/
        }
        Collections.sort(list);


        for (Edge e : list) {
            update(e.pos,1);
            cnt[e.pos] = sum(e.pos);
        }
        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(cnt[i]));
            bw.write('\n');
        }
        bw.flush();bw.close();
    }


    private static int sum(int index) {
        // TODO Auto-generated method stub
        int ans = 0;
        for (int i = index; i > 0; i -= (i&-i)) {
            ans += tree[i];
        }
        return ans;
    }

    public static void update(int index,int dif){
        for (int i = index; i <= N; i += (i&-i)) {
            tree[i] += dif;
        }
    }



}