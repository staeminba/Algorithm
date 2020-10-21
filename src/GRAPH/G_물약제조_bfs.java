package GRAPH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_��������_bfs {
	static int A,B;
	static int C,D;
	static Edge[][] arr;
	static int[][] visit;
	static Queue<Edge> q;
	static int result;
	
	static class Edge{
		int a,b;
		public Edge(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
	    A = Integer.parseInt(st.nextToken());
	    B = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    
	    C = Integer.parseInt(st.nextToken());
	    D = Integer.parseInt(st.nextToken());
    	
	    visit = new int[1001][1001];
	    arr = new Edge[1001][1001];
    	q = new LinkedList<>();
    	
    	bfs();
    	
    	
	}



	private static void bfs() throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		q.add(new Edge(0,0));
		visit[0][0] = 1;
		while(!q.isEmpty()){
			Edge now = q.poll();
			int ca = now.a, cb = now.b;
			if(ca == C && cb == D){//�°� ä�m����
				bw.write(String.valueOf(visit[ca][cb]));
				bw.flush();
				return;
			}
			Edge[] cs ={
					new Edge(A,cb),//a�� ���� ä��� ��� 
					new Edge(ca,B),//b�� ���� ä��� ���
					new Edge(ca,0),//b�� ��� ������ ��� 
					new Edge(0,cb),//a�� ��� ������ ���
					new Edge(Math.min(ca+cb, A), ca+cb > A ? ca+cb - A : 0),//a�� b�� ��� ���
					new Edge(ca+cb > B ? ca+cb - B : 0,Math.min(ca+cb, B))//b�� a�� ��� ���
					};
			for (int i = 0; i < 6; i++) {
				int na = cs[i].a;
				int nb = cs[i].b;
				if(visit[na][nb] == 0){
					visit[na][nb] = visit[ca][cb] + 1;
					q.add(new Edge(na,nb));
				}
			}
		}
		bw.write("-1");
		bw.flush();
	}

}

