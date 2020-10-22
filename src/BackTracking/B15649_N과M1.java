package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15649_N°úM1 {
	static int M,N;
	static boolean[] visit;
	static int[] num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         num = new int[M+1];
         visit = new boolean[N+1];
         Arrays.fill(visit, false);
         perm(0);
        
       
    }
    
    public static void perm(int r){    
        if(r==M) {
        	for(int i = 1 ; i<=M ; i++) {
				System.out.print(num[i] + " ");
			}
        	System.out.println();
            return;
        }
        else{
            for(int i = 1; i <= N; i++){
            	if(visit[i])
            		continue;
            	visit[i] = true;
            	num[r+1] = i;
            	perm(r+1);
            	visit[i] = false;
            }
        }
    }
}