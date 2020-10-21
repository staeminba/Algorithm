package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class B1753_최단경로_다익스트라 {
 
	static int vertex;
	static int edge;
	static int k;
	
	static int distance[];
	
	
	static class Edge implements Comparable<Edge>{
		int start;
	    int end;
	    int value;
	 
	    Edge(int start,int end, int value) {
	    	this.start = start;
	        this.end = end;
	        this.value = value;
	    }

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.value - e.value;
		}
	}
	
	static ArrayList<Edge> list;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	vertex 	= Integer.parseInt(st.nextToken());
    	edge	= Integer.parseInt(st.nextToken());
    	k		= Integer.parseInt(br.readLine());
    	
    	distance	= new int[vertex + 1];
    	
    	Arrays.fill(distance, Integer.MAX_VALUE);
    	
    	list = new ArrayList<Edge>();
    	
    	
    	for (int i = 1; i <= edge; i++) {
    		st = new StringTokenizer(br.readLine());
    		list.add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    	}
    	
    	dijkstra();
        
    }



    private static void dijkstra(){
    	PriorityQueue<Edge> q = new PriorityQueue<Edge>();
    	
    	q.add(new Edge(k,k,0));
    	distance[k] = 0;
    	
    	while(!q.isEmpty()){
    		Edge cur = q.poll();
    		// 이미 방문한 정점이면 이후 로직을 수행하지 않고 while 반복문으로 이동한다.
    		for (Edge next : list) {
				//if (distance[next.end] > distance[cur.end] + next.value) {
    				if(next.start != cur.end || distance[next.start] == Integer.MAX_VALUE){
    					continue;
    				}
    				if(distance[next.end] > next.value + distance[next.start]){
    					distance[next.end] = next.value + distance[next.start];
    					System.out.println("next.start : " + next.start +  " next.end : " + next.end + " distance[next.end] : "+ distance[next.end]);
    					q.add(new Edge(next.start, next.end, distance[next.end]));
    				}
			}
    		System.out.println();
    	}
    	
    	// 출력
        for (int i = 1; i <= vertex; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
               System.out.println(distance[i]);
            } else {
               System.out.println("INF");
            }
        }
    }
    
}
