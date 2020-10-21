package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class °¡Áî¾Æ {
	
	static int N,K;
	static int[] arr;
	static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
			//list.add(new Edge(i,Integer.parseInt(st.nextToken())));
			arr[i] = Integer.parseInt(st.nextToken());
		}
        for (int i = 1; i <= N ; i++) {
        	for (int j = i+1; j <= N ; j++) {
        		if(arr[j] > arr[i]){
        			result = Math.max(result, K/arr[i]*arr[j] + K%arr[i]);
        		}
        	}
        	System.out.println(result);
        }
    }

}