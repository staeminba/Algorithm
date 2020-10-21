package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class G_울타리만들기 {
	static int N;
	static ArrayList<Edge> list;
	static Stack<Integer> stack;
	static Edge first;
	static double result;
	
	
	static class Edge implements Comparable<Edge>{
		int x,y;
		
		public Edge(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Edge o){
            int result = ccw(first,this,o);
            if(result > 0){
                return -1;
            }else if(result < 0){
                return 1;
            }else{
                if(getDistance(first,this) > getDistance(first,o)){
                    return 1;
                }
            }
            return -1;
        }
	}

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	list = new ArrayList<>();
    	first = new Edge(40000,40000);
    	for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(y < first.y || (y == first.y && x < first.x)){
				first.x = x; first.y = y;
			}
			list.add(new Edge(x,y)); 
			
		}
    	
    	Collections.sort(list);
    	
    	ArrayList<Edge> temp = new ArrayList<>();
    	
    	for (int i = 0; i < list.size(); i++) {
    		while(temp.size() > 1 &&
    				ccw(temp.get(temp.size()-2),temp.get(temp.size()-1), list.get(i)) <= 0){
    			temp.remove(temp.size()-1);
    		}
    		temp.add(list.get(i));
		}
		System.out.println(temp.size());
	}
	
	public static int ccw(Edge a, Edge b,Edge c){
		int result = (a.x*b.y + b.x*c.y + c.x*a.y) - (b.x*a.y + c.x*b.y + a.x*c.y);
		if (result > 0){
            return 1;
        }else if (result < 0){
            return -1;
        }else{
            return 0;
        }
	}
	
	static public long getDistance(Edge a, Edge b){
	       return (b.x-a.x)*(b.x-a.x) + (b.y-a.y)*(b.y-a.y);
    }



}