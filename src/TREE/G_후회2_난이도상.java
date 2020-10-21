package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G_후회2_난이도상 {

	static int N,M;
	static int arr[];
	static long tree[];
	static Edge tree2[];
	static int leaf;
	static class Edge{
		int pos = 0;
		long num = 0;
		
		public Edge(int pos,long num){
			this.pos = pos;
			this.num = num;
		}
	}

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
        tree2 = new Edge[leaf << 1];
        for (int i = 0 ; i < tree2.length ; i++) {
        	tree2[i] = new Edge(0,0);
		}
        st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init();
		//initMax();
     
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1){
				bw.write(sum(b,c) + "\n");
			}else{
				Edge e = query(b,c);
				//System.out.println(e.pos + " " + e.num);
				update(e.pos,e.num/2);
				//update2(e.pos,e.num/2);
			}
		}
		bw.flush();
		bw.close();
    }
   
	private static void init() {
		// TODO Auto-generated method stub
		for (int i = leaf; i < leaf+N; i++){
			tree[i] = arr[(i-leaf)+1];
			tree2[i] = new Edge((i-leaf)+1,arr[(i-leaf)+1]);
		}for (int i = leaf-1; i > 0; i--) {
			tree[i] = tree[i<<1] + tree[(i<<1) + 1];
			Edge m = tree2[i<<1].num >= tree2[(i<<1) + 1].num ? tree2[i<<1] : tree2[(i<<1)+1];
			tree2[i] = m;
		}
	}
    
	private static void update(int idx, long dif) {
		// TODO Auto-generated method stub
		idx += (leaf - 1);
		tree2[idx].num = dif;
		long diff = tree[idx] - dif;
		tree[idx] = dif;
		while((idx >>= 1) > 0){
			tree[idx] -= diff;
			Edge m = tree2[idx<<1].num >= tree2[(idx<<1) + 1].num ? tree2[idx<<1] : tree2[(idx<<1)+1];
			tree2[idx] = m;
		}
	}
	
	 private static void update2(int pos, long dif) {
			// TODO Auto-generated method stub
    	tree2[pos + (leaf - 1)].num = dif;
    	for (int i = leaf-1; i > 0; i--) {
			Edge m = tree2[i<<1].num >= tree2[(i<<1) + 1].num ? tree2[i<<1] : tree2[(i<<1)+1];
			tree2[i] = m;
		}
	}

	private static long sum(int l, int r) {
		// TODO Auto-generated method stub
		long result = 0;
		l += (leaf-1); 
		r += (leaf-1);
		//System.out.println("leaf : " + leaf + " l : " + l + " r : " + r);
		while(l < r){
			if((l & 1) == 1) //홀수면
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
	
	private static Edge query(int l, int r) {
		// TODO Auto-generated method stub
		Edge result = new Edge(0,0);
		l += (leaf-1); 
		r += (leaf-1);
		//System.out.println("leaf : " + leaf + " l : " + l + " r : " + r);
		while(l < r){
			if((l & 1) == 1){ //홀수면
				if(result.num == tree2[l].num){
					result = result.pos > tree2[l].pos ? tree2[l] : result;
				}else{
					result = result.num > tree2[l].num ? result : tree2[l];
				}
				l++;
			}
			if((r & 1) != 1){
				if(result.num == tree2[r].num){
					result = result.pos > tree2[r].pos ? tree2[r] : result;
				}else{
					result = result.num > tree2[r].num ? result : tree2[r];
				}
				r--;
			}
			l >>= 1;
			r >>= 1;
		}
		//System.out.println("leaf2 : " + leaf + " l : " + l + " r : " + r);
		if(l == r){
			//System.out.println("!111 " + result.pos);
			if(result.num == tree2[l].num){
				result = result.pos > tree2[l].pos ? tree2[l] : result;
			}else{
				result = result.num > tree2[l].num ? result : tree2[l];
			}
		}
		return result;
	}

	

}