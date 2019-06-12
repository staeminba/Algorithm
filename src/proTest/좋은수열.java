package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class 좋은수열 {
 

	static int N;
	static String str;
	static int back;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        back = N/2;
        
        for (String i = 1; i <= N; i++) {
        	add(i);
		}
        
    }
    public static int add(String i){
    }
	
}