package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class B1395_½ºÀ§Ä¡ {

    static int N,M;
    static int q,s,t;
    static long[] tree;
    static long[] lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new long[N*4];
        lazy = new long[N*4];

        for (int i = 1; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());
            q = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            if(q == 0){
                update_lazy(1,N,1,s,t,1);
            }else{
                sb.append(sum_lazy(1,N,1,s,t)+"\n");
            }

        }
        System.out.println(sb);
    }

    public static void update_lazy(int start,int end,int node,int left,int right,long dif){
        if(lazy[node] != 0)
            propagation(start,end,node);

        if(left > end || right < start)
            return;



        if(left <= start && right >= end){
            if(start != end){
                lazy[node*2] ^= dif;
                lazy[node*2+1] ^= dif;
            }
            tree[node] = (end-start+1) - tree[node];
            return;
        }

        int mid = (start+end)/2;
        update_lazy(start,mid,node*2,left,right,dif);
        update_lazy(mid+1,end,node*2+1,left,right,dif);
        tree[node] = tree[node*2] + tree[node*2+1];

    }

    public static long sum_lazy(int start,int end,int node,int left,int right){
        if(left > end || right < start)
            return 0;
        if(lazy[node] != 0)
            propagation(start,end,node);

        if(left <= start && right >= end){
            return tree[node];
        }

        int mid = (start+end)/2;
        return sum_lazy(start,mid,node*2,left,right) + sum_lazy(mid+1,end,node*2+1,left,right);
    }

    public  static void propagation(int start,int end,int node){
        //if(lazy[node]%2==1)
        tree[node] = (end-start+1) - tree[node];
        if (start != end) {
            lazy[node*2] ^= 1;
            lazy[node*2+1] ^= 1;
        }
        lazy[node] = 0;
    }



}