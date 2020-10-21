package Implements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class G_이상한강의실_stack {
	
	static int N;
	static Stack<Edge> stack;
	static int[] res;
	static int[] arr;
	
	static class Edge{
		int num;
		int pos;
		
		Edge(int num,int pos){
			this.num = num;
			this.pos = pos;
		}
	}

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	N = Integer.parseInt(br.readLine());
    	res = new int[N+1];
    	arr = new int[N+1];
    	stack = new Stack<>();
    	
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	res[1] = -1;
		stack.push(new Edge(arr[1],1));
    	for (int i = 1; i <= N; i++) {
			
			Edge top = stack.peek();
			if(top.num > arr[i])
				res[i] = top.pos;
			else{
				while(!stack.isEmpty() && stack.peek().num <= arr[i]){
					top = stack.pop();
				}
				if(stack.isEmpty())
					res[i] = -1;
				else
					res[i] = stack.peek().pos;
				
			}
			stack.push(new Edge(arr[i],i));
				
		
		}
    	
    	for (int i = 1; i <= N; i++) {
			bw.write(res[i] + " ");
			
		}
    	bw.flush();
    	bw.close();
    
    }


}