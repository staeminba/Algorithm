package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G_선별진료소 {
	
	static int N;
	static int K;
	static int arr[];
	static int result;
	static final int MAXTIME = (int) 1e9;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	arr = new int[K+1];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    	
    	bw.write(String.valueOf(binarySearch()));
    	bw.flush();
	}

	private static int binarySearch() {
		// TODO Auto-generated method stub
		int l = 1;
		int r = MAXTIME;
		
		int mid = 0;
		while(l <= r){
			mid = (l+r)/2;
			//System.out.println("l : " + l + " r : " + r + " mid : " + mid + 88/2);
			long temp = 0;
			for (int i = 1; i <= K; i++) {
				temp += mid/arr[i];
			}
			//System.out.println("temp : " + temp + " mid : " + mid + " N : " + N);
			if(temp < N)
				l = mid + 1;
			else{
				r = mid - 1;
				result = mid;
			}
				
		}
		return result;
	}
}
