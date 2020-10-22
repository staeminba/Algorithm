package MATH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1947_선물전달 {
	static int N;
	static long[] arr;
    public static void main(String[] args) throws IOException {
    	BufferedReader br;
    	br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	
    	arr = new long[N+2];
    	arr[1] = 0;
    	arr[2] = 1;
    	
    	int result = 0;
    	for (int i = 3; i <= N; i++) {
    		arr[i] = (i-1)*(arr[i-2]+arr[i-1])%1000000000;
    		
		}
    	System.out.println(arr[N]);
    
    	
    }
	
}