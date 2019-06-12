package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class ¼û¹Ù²ÀÁú2 {
 

	static int str;
	static int end;
	static int max = 100001;
	static int kind = 0;
	
	static boolean	visited[];
	
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
        
    	visited	= new boolean[100001];
    	
    	bfs(str);
    	System.out.println(max);
    	System.out.println(kind);
    	
    	
    }
	private static int bfs(int x) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		
		q.offer(new Node(x,0));
		visited[x] = true;
		
		Node temp;
		
		while(!q.isEmpty()){
			
			int here = q.peek().x;
			temp = q.poll();
			int cnt = temp.cnt;
			int pos = temp.x;
			
			visited[pos] = true;
			
			
			if(here == end){
				if(cnt <= max){
					max = cnt;
					kind++;
				}else 
					break;
			}
			
			
			for (int i = 0; i < 3; i++) {
				int nx;
				
				if(dx[i] != 2){
					nx = pos + dx[i];
				}else{
					nx = pos*2;
				}
				
				if(nx <= 0 || nx > 100000 || visited[nx])
					continue;
				
				q.offer(new Node(nx,cnt+1));
			}
		}
		return 0;
	}
	
}