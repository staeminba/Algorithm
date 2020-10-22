package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B13549_¼û¹Ù²ÀÁú3_BFS {

	static int str;
	static int end;
	
	static boolean visited[];
	static int parent[];
	
	static int dx[]={-1,1,2};
	
	static class Node{
		int x,cnt;
		Node(int x,int cnt){
			this.x = x;
			this.cnt = cnt;
		}
		
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        str = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
       
        /*
        if(str >= end){
            System.out.println(str - end);
            return;
        }*/
        
    	visited = new boolean[100001];
    	parent = new int[100001];
    	
    	int result = bfs(str);
    	
    	System.out.println(result);
    	Stack<Integer> stack = new Stack<>();
    	for (int i = end; i != parent[i]; i = parent[i]) {
    		stack.push(parent[i]);
		}
    	
    	while(!stack.isEmpty()){
    		System.out.print(stack.pop() + " ");
    	}
    	System.out.print(end);
    	
    	
    }
	private static int bfs(int x) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		
		q.offer(new Node(x,0));
		
		visited[x] = true;
		parent[x] = str;
		
		Node temp;
		
		while(!q.isEmpty()){
			temp = q.poll();
			
			int pos = temp.x;
			int cnt = temp.cnt;
			
			if(pos == end){
				return cnt;
			}
			
			for (int i = 0; i < 3; i++) {
				int nx;
				
				if(dx[i] != 2){
					nx = pos + dx[i];
				}else{
					nx = pos*2;
				}
				
				if(nx < 0 || nx > 100000 || visited[nx])
					continue;

				q.offer(new Node(nx,cnt+1));
				visited[nx] = true;
				parent[nx] = pos;
			}
		}
		return 0;
	}
	
}