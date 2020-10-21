package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class G_가위바위보_서로소 {

	static int N,M;
	static int par[];
	static int sum[];
	static int res;
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	par = new int[N+1];
    	sum = new int[N+1];
    	for (int i = 1; i <= N; i++) {
			par[i] = i;
			sum[i] = 1;
		}
    	
    	
    	for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int c = find(a);
			int d = find(b);
			
			if(c == d)
				continue;
			
			//System.out.println("c : " + c + " d : " + d);
			sum[c] += sum[d];
			sum[d] = sum[c];
			
			par[d] = c;
		}
    	for (int i = 1; i <= N; i++) {
    		if(find(i) == i)
    			System.out.println(i + " " + sum[i]);
			
		}
	}
	
	public static int find(int n){
		if(par[n] == n)
			return n;
		
		return par[n] = find(par[n]);
	}


}