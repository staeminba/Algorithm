package GRAPH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1854_K번째최단경로찾기_다익스트라 {

	static int n,m,k;
	static int vertex;
	static int edge;
	
	static PriorityQueue<Long>  distance[];
	
	static class comp implements Comparator<Long>{

		@Override
		public int compare(Long o1, Long o2) {
			// TODO Auto-generated method stub
			return (int)(o2-o1);
		}

	
		
	}
	
	static class Edge implements Comparable<Edge>{
	    int end;
	    long value;
	 
	    Edge(int end, long value) {
	        this.end = end;
	        this.value = value;
	    }

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return (int) (this.value - e.value);
		}
	}
	
	static ArrayList<Edge>[] list;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n 	= Integer.parseInt(st.nextToken());
    	m	= Integer.parseInt(st.nextToken());
    	k 	= Integer.parseInt(st.nextToken());
    	
    	distance	= new PriorityQueue[n + 1];
    	for (int i = 1; i <= n; i++) {
			
		}
    	
    	list = new ArrayList[n+1];
    	for (int i = 1; i <= n; i++) {
    		list[i] = new ArrayList<Edge>();
    		distance[i] = new PriorityQueue<Long>(new comp());
		}
    	
    	
    	
    	for (int i = 1; i <= m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		list[a].add(new Edge(b,c));
    	}
    	
    	dijkstra();
        
    }



    private static void dijkstra(){
    	PriorityQueue<Edge> q = new PriorityQueue<Edge>();
    	
    	q.add(new Edge(1,0));
    	distance[1].add((long) 0);
    	
    	while(!q.isEmpty()){
    		Edge cur = q.poll();
    		// 이미 방문한 정점이면 이후 로직을 수행하지 않고 while 반복문으로 이동한다.
    		for (Edge next : list[cur.end]) {
				if(distance[next.end].size() < k){
    				distance[next.end].add(next.value + cur.value);
    				q.add(new Edge(next.end, next.value + cur.value));
    			}else if(distance[next.end].peek() > next.value + cur.value){
    				distance[next.end].poll();
    				distance[next.end].add(next.value + cur.value);
    				q.add(new Edge(next.end, next.value + cur.value));
				}
			}
    	}
    	
    	// 출력
        for (int i = 1; i <= n; i++) {
        	    if (distance[i].size() < k) {
            	System.out.println(-1);
            } else {
            	System.out.println(distance[i].poll());
            }
        }
    }
    
}
