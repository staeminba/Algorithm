package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G_√Îæ‡¡° {

	static int N,M;
    static int arr[];
    static int tree[];
    static int leaf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        leaf = 1 << (int) (Math.ceil(Math.log10(N) / Math.log10(2)));
        tree = new int[leaf << 1];
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        init();

        for (int i = 1; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            //System.out.println(l + " " + r);
            System.out.println(query(l,r));
        }

    }

    private static int query(int l, int r) {

        int res = Integer.MAX_VALUE;
        l += (leaf-1);
        r += (leaf-1);
        while(l < r){
            //if((l & 1) != 0 ){ // »¶ºˆ∏È
            if ((l % 2) != 0) { // »¶ºˆ∏È
                res = Math.min(res,tree[l++]);
            }
            //if((r & 1) == 0 ){ // ¬¶ºˆ∏È
            if ((r % 2) == 0) {
                res = Math.min(res,tree[r--]);
            }
            l >>= 1;
            r >>= 1;

        }
        if(l == r)
        	res = Math.min(tree[l],res);
        return res;
    }

    private static void init() {
        for (int i = leaf; i < leaf+N ; i++)
            tree[i] = arr[i - leaf + 1];
        for (int i = leaf - 1; i > 0 ; i--) {
            tree[i] = Math.min(tree[i << 1] , tree[(i << 1)+1]);
        }
    }


}