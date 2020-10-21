package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_π‚∞ÌΩÕ¿∫º±_dfs {
	static int N,A;
	static int cnt;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	A = Integer.parseInt(st.nextToken());
    	

    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 0)
				cnt++;
			else
				cnt = 0;
			if(cnt >= A){
				System.out.println("no");
				return;
			}
			
		}
    	
    	System.out.println("yes");
    }

}