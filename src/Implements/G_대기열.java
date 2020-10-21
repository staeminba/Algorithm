package Implements;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class G_대기열 {
	static int N,C;
	static ArrayList<Edge> list;
	static ArrayList<Integer> prior;
	static int result;
	static class Edge{
		int a,b;
		
		public Edge(int a,int b){
			this.a = a;
			this.b = b;
		}
	}
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	list = new ArrayList<>();
    	prior = new ArrayList<>();
    	Deque<Edge> q = new LinkedList<>();
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		Edge e = new Edge(a,b);
    		list.add(e);
    		q.add(e);
    		prior.add(b);
		}
    	
    	C = Integer.parseInt(br.readLine());
    	prior.sort((num1 , num2) -> num1 - num2);
    	
    	
    	while(true){
    		Edge e = q.pollFirst();
    		int min = prior.get(0);
			if(e.b != min) //최소값이 아니면
				q.offerLast(e);
			else{
				if(e.a == C){
					result++;
					break;
				}else{
					result++;
					prior.remove(0);
				}
			}
			
		}
    	
    	System.out.println(result);
    
	}
	

}
	