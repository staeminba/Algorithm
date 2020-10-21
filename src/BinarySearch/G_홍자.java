package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_È«ÀÚ {
	
	static long N;
	static long a,b;
	static long l,r,mid;
	static long res = Long.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = 1 ; r = 1000000000;
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		while(l <= r){
			mid = (l+r)/2;
			long temp = solve(mid);
			if(temp >= N ){
				res = Math.min(mid, res);
				r = mid-1;
			}else
				l = mid+1;
			
		}
		System.out.println(res);

	}

	private static long solve(long num) {
		// TODO Auto-generated method stub
		//System.out.println(num);
		return (num*a - (num-1)*b);
		
	}


}