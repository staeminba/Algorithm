package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G_°í¹«ÁÙ´ç±â±â_Å½¿å {
	
	static long N,K;
	static long result;
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Long.parseLong(st.nextToken());
    	K = Long.parseLong(st.nextToken());
    	
    	for (int i = 1; i <= K; i++) {
    		if(K/i < N){
    			result = i;
    			break;
    		}else if(K/i == N && K%i == 0){
    			result = i;
    			break;
    		}
		}
    	System.out.println(result);
	}
	

}
	