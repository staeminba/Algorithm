package Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B6549_히스토그램에서가장큰직사각형_STACK {
	
	static int T;
	static int N;
	static long[] nemo;
	static Stack<Integer> stack = new Stack<Integer>();
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	T = Integer.parseInt(br.readLine());
    	for (int i = 0; i < T; i++) {
    		N = Integer.parseInt(br.readLine());
    		nemo = new long[N+1];
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
				nemo[j] = Integer.parseInt(st.nextToken());
			}

    		stack.clear();
    		
    		System.out.println(Solution());
		}*/		
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());

				if(N == 0){
					break;
				}
				nemo = new long[N+1];
				for (int j = 0; j < N; j++) {
					nemo[j] = Integer.parseInt(st.nextToken());
				}
		
				
				stack.clear();
				
				System.out.println(Solution());
			}
	}

	private static long Solution() {
		// TODO Auto-generated method stub
		long ans = 0;
		for (int i = 0; i < N; i++) {
			while(!stack.isEmpty() && nemo[stack.peek()] > nemo[i]){
				long height = nemo[stack.pop()];
				long width	= i;
				
				if(!stack.isEmpty()){
					width = i - stack.peek() - 1;
				}
				
				ans = Math.max(ans, width * height);
			} 
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			long height = nemo[stack.pop()];
			long width = N;

			if (!stack.isEmpty()) {
				width = N - stack.peek() - 1;
			}

			ans = Math.max(ans, width * height);
		}

		return ans;
	}

}
