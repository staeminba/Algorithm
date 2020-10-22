package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13913_¼û¹Ù²ÀÁú4_BFS {

	static int str;
	static int end;
	
	static boolean visited[];
	
	static int dx[]={2,-1,1};
	
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
       
    	visited = new boolean[100001];
    	
    	System.out.println(bfs(str));
    	
    	
    }
	private static int bfs(int x) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		
		q.offer(new Node(x,0));
		
		visited[x] = true;
		
		Node temp;
		
		while(!q.isEmpty()){
			temp = q.poll();
			
			int cnt = temp.cnt;
			int pos = temp.x;
			
			if(pos == end){
				return cnt;
			}
			
			for (int i = 0; i < 3; i++) {
				int nx;
				
				if(dx[i] != 2){
					nx = pos + dx[i];
					if(nx < 0 || nx > 100000 || visited[nx])
						continue;
					
					q.offer(new Node(nx,cnt+1));
					visited[nx] = true;
				}else{
					nx = pos*2;
					if(nx <= 0 || nx > 100000 || visited[nx])
						continue;
					
					q.offer(new Node(nx,cnt));
					visited[nx] = true;
				}
				
			}
		}
		return 0;
	}
	
}