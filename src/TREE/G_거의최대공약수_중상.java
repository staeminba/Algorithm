package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G_거의최대공약수_중상 {

	static int N, M;
    static int[] arr;
    static long[] tree;
    static int leaf;
    static long result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        leaf = 1 << (int) (Math.ceil(Math.log10(N) / Math.log10(2)));
        tree = new long[leaf << 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

     
        for (int i = 1; i <= N; i++) {
            int temp = arr[i];
            //arr[i] = 0;
            //init();
            result = Math.max(result ,  gcd(sum(1,i-1), sum(i+1,N)));
            //arr[i] = temp;
        }
        System.out.println(result);

    }

    private static long sum(int l, int r) {
        // TODO Auto-generated method stub
        long res = 0;
        l += (leaf - 1);
        r += (leaf - 1);
        // System.out.println("leaf : " + leaf + " l : " + l + " r : " + r);
        while (l < r) {
            if ((l % 2) != 0) { // 홀수면
                res = gcd(tree[l],res);
                l++;
            }
            if ((r % 2) == 0) {
                res = gcd(tree[r],res);
                r--;
            }
            l >>= 1;
            r >>= 1;
        }
         //System.out.println(l+"," + r + " res : " + res + " tree[l] : " + tree[l]);
        if (l == r)
            res = gcd(res,tree[l]);
        return res;
    }

    private static void update(int idx, int val) {
        // TODO Auto-generated method stub
        idx += (leaf - 1);
        long diff = val - tree[idx];
        tree[idx] = val;
        /*
         * while(idx >= 2){ idx >>= 1; tree[idx] += diff; }
         */
        while (idx >= 2) {
            idx >>= 1;
            tree[idx] += diff;
        }
    }

    private static void init() {
        // TODO Auto-generated method stub
        for (int i = leaf; i < leaf + N; i++)
            tree[i] = arr[i - leaf + 1];
        for (int i = leaf - 1; i > 0; i--) {
            long a = tree[i<<1];
            long b = tree[(i<<1)+1];
            tree[i] = gcd(tree[i << 1], tree[(i << 1) + 1]);
        }
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}