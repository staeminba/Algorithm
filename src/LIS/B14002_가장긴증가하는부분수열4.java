package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class B14002_가장긴증가하는부분수열4 {
 

	static int N;
	static int[] arr;
	static int[] dp;
	static int[] pos;
	static int now;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	Stack<Integer> stack = new Stack<Integer>();
    	arr = new int[N];
    	dp  = new int[N];
    	pos  = new int[N];
    	for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    	
    	dp[0] = arr[0];
    	pos[0] = 0;
    	now = 0;
   		for (int i = 1; i < N; i++) {
			if(arr[i] > dp[now]){
				dp[++now] = arr[i];
				pos[i] = now; 
			}else{
				int num = lowerbound(i); 
				dp[num] = arr[i];
				pos[i] = num; 
			}
		}
        System.out.println(now+1);
   		for (int i = N-1; i >=  0; i--) {
			if(pos[i] == now){
				stack.push(arr[i]);
				now--;
			}
		}
   		while(!stack.isEmpty()){
   			System.out.print(stack.pop() + " ");
   		}
    			
    }

	private static int lowerbound(int num) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dp.length; i++) {
			if(arr[num] <= dp[i]){
				return i;
			}
		}
		return 0;
	}
}