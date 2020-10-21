package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_보안검색 {
	
	static int N;
	static long K;
	static long[] arr;
	static long sum;
	static long result;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sum += arr[i];
		}
        	binarySearch();
        	System.out.println(result);
    }

	private static void binarySearch() {
		// TODO Auto-generated method stub
		long l = 0; 
		long r = 1000000000000000L;
		while(l <= r){
			long mid = (l+r)/2;
			long sum = 0;
			for (long i : arr) {
				sum += mid/i;
			}
			//System.out.println(" sum : " + sum + " mid : " + mid + " l : " + l + " r : " + r);
			if(sum >= K){
				result = mid;
				r = mid -1;
			}else{
				l = mid + 1;
				
			}
		}
		
	}

}