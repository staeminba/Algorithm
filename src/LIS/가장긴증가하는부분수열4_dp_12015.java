package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class 가장긴증가하는부분수열4_dp_12015 {
 

	static int N;
	static int max;
	static int ans = 1;
	static int[] dp;
	static int[] arr;
	static int[] pos;
	static Stack<Integer> stack;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dp  = new int[N+1];
        arr = new int[N+1];
        pos = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
		}
        dp[1] = arr[1];
        pos[1] = 1;
        stack = new Stack<>();
        for (int i = 2; i <= N; i++) {
        	System.out.println("arr[i] : " + arr[i]+ " dp[ans] : " + dp[ans]);
        	if(arr[i] > dp[ans]){
        		dp[++ans] = arr[i];
        		pos[i] = ans;
        	}else{
        		int num = lowerBound(i);
        		System.out.println("num : " + num);
        		dp[num] = arr[i];
        		pos[i] = num;
        	}
        	System.out.println(pos[i]);
		}
        System.out.println(ans);
        int cnt = ans;
        for (int i = N; i > 0; i--) {
        	
        	if(pos[i] == cnt){
        		stack.push(arr[i]);
        		cnt--;
        	}
		}
        
        while(!stack.isEmpty()){
        	System.out.print(stack.pop() + " ");
        }
    }
    public static int lowerBound(int n){
    	for (int i = 1; i <= n; i++) {
        	if(dp[i] >= arr[n]){
        		return i;
        	}
		}
    	ans = 1;
    	return n;
    }
	
}