package GRAPH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_싸움의기술_서로소 {

	static int N,M,R;
	static int[] par;
	static ArrayList<Integer>[] list;
	
	

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	list = new ArrayList[N+1];
    	par = new int[N+1];
    	
    	for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			par[i] = i;
		}
    	
    	for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int c = find(a);
			int d = find(b);
			if(c != d)
				par[d] = find(c);
		}
    	
    	R = Integer.parseInt(br.readLine());
    	
    	for (int i = 1; i <= R; i++) {
    		st = new StringTokenizer(br.readLine());

    		int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a) != find(b))
				bw.write("0\n");
			else
				bw.write("1\n");
		}
    	bw.flush();
    	bw.close();
    
    }

	public static int find(int n){
		if(par[n] == n)
			return n;
		return par[n] = find(par[n]);
	}
}