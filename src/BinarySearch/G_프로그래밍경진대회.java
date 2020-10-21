package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_프로그래밍경진대회 {
	
	static int N;
	static int[] arr;
	static long S;
	static long max;
	static long sum;
	static long result;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
        S = Long.parseLong(br.readLine());
        Arrays.sort(arr);
        if(sum <= S)
        	System.out.println(arr[N-1]);
        else{
        	binarySearch();
        	System.out.println(result);
        }
    }

	private static void binarySearch() {
		// TODO Auto-generated method stub
		int l = arr[0]; int r = arr[N-1];
		while(l <= r){
			int mid = (l+r)/2;
			long sum = 0;
			for (int i : arr) {
				sum += Math.min(mid , i);
			}
			if(sum > S){
				r = mid -1;
			}else{
				l = mid + 1;
				result = mid;
			}
		}
		
	}

}