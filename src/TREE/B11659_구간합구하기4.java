package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class B11659_구간합구하기4 {
 
	static int N,M,K;
    static long tree[];
    static int arr[];
    static int leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        leaf = 1 << (int) Math.ceil(Math.log10(N)/Math.log10(2));
        tree = new long[leaf<<1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();
        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(sum(a, b));
        }

    }

    public static void init() {
        // TODO Auto-generated method stub
        for (int i = leaf; i < leaf+N; i++)
            tree[i] = arr[i - leaf + 1];
        for (int i = leaf-1; i > 0; i--)
            tree[i] = tree[i << 1] + tree[(i << 1) + 1];
    }

    public static long sum(int left,int right){
        long sum = 0;
        left  += (leaf-1);
        right += (leaf-1);
        while(left <= right){
            if((left&1) != 0 )
                sum += tree[left++];
            if((right & 1) == 0)
                sum += tree[right--];
            left >>= 1;
            right >>= 1;
        }
        if(left == right)
            sum += tree[left];

        return sum;
    }
}