package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G_ÈÄÈ¸ {

	static int N,M;
	static int arr[];
	static long tree[];
	static int leaf;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];
        leaf = 1 << (int) Math.ceil(Math.log10(N)/Math.log10(2));
        //System.out.println(leaf + " " + (leaf<<1));
        tree = new long[leaf << 1];
        
        st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init();
     
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1){
				bw.write(sum(b,c) + "\n");
			}else{
				update(b,c);
			}
		}
		bw.flush();
		bw.close();
    }

	private static void update(int idx, int dif) {
		// TODO Auto-generated method stub
		idx += (leaf - 1);
		long diff = tree[idx] - dif;
		tree[idx] = diff;
		while((idx >>= 1) > 0){
			tree[idx] = tree[idx << 1] + tree[(idx << 1) + 1];
		}
	}

	private static long sum(int l, int r) {
		// TODO Auto-generated method stub
		long result = 0;
		l += (leaf-1); 
		r += (leaf-1);
		//System.out.println("leaf : " + leaf + " l : " + l + " r : " + r);
		while(l < r){
			if((l & 1) == 1) //È¦¼ö¸é
				result += tree[l++];
			if((r & 1) != 1)
				result += tree[r--];
			l >>= 1;
			r >>= 1;
		}
		//System.out.println("leaf2 : " + leaf + " l : " + l + " r : " + r);
		if(l == r)
			result += tree[l];
		return result;
	}

	private static void init() {
		// TODO Auto-generated method stub
		for (int i = leaf; i < leaf+N; i++)
			tree[i] = arr[(i-leaf)+1];
		for (int i = leaf-1; i > 0; i--) {
			tree[i] = tree[i<<1] + tree[(i<<1) + 1];
		}
	}

}
