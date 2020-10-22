package TREE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2336_±²ÀåÇÑÇÐ»ý {

	static class Edge implements Comparable<Edge>{
		int first;
		int second;
		int third;
		
		
		public Edge(int first,int second,int third){
			this.first  = first;
			this.second = second;
			this.third = third;
			
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if(this.first - o.first > 0)
				return 1;
			else if(this.first - o.first < 0)
				return -1;
			else 
				return 0;
			
					
		}
	}
	
	static int N;
	static final int Max = Integer.MAX_VALUE;
	static ArrayList<Edge> list;
	static int tree[];
	static int rank1[],rank2[],rank3[];
	static int result = 0;
    	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        list = new ArrayList<>();
        rank1 = new int[N+1];
        rank2 = new int[N+1];
        rank3 = new int[N+1];
        tree = new int[N*4];
 
        for (int i = 1; i <= 3; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= N; j++) {
        		
        		int num = Integer.parseInt(st.nextToken());
//        		System.out.println(num + " , " + j);
        		if(i==1){
        			rank1[num] = j;
        		}else if(i==2){
        			rank2[num] = j;
        		}else if(i==3){
        			rank3[num] = j;
        		}
        	}
		}
        init(1,N,1);
        for (int j = 1; j <= N; j++) {
        	list.add(new Edge(rank1[j],rank2[j],rank3[j]));
        }
        Collections.sort(list);
        for (int j = 0; j < N; j++) {
        	if(sum(1,N,1,1,list.get(j).second-1) > list.get(j).third){
        		result++;
        	}
        	update(1,N,1,list.get(j).second,list.get(j).third);
        }
        System.out.println(result);
    }
    
    public static int init(int start,int end,int node){
    	if(start == end){
    		return tree[node] = Max;
    	}
    	
    	int mid = (start+end)/2;
    	return tree[node]= Math.max(init(start,mid,node*2), init(mid+1,end,node*2+1));
    }
    
    public static int sum(int start,int end,int node,int left,int right){
    	if(start > right || end < left)
    		return Max;
    	
    	if(left <= start && end <= right){
    		return tree[node];
    	}
    	
    	int mid = (start+end)/2;
    	return Math.min(sum(start,mid,node*2,left,right),sum(mid+1,end,node*2+1,left,right));
    }

    public static void update(int start,int end,int node,int index,int dif){
    	if(index < start || end < index)
    		return;
    	tree[node] = Math.min(tree[node],dif);
    	if(start == end)
    		return;
    	
    	int mid = (start+end)/2;
		
		update(start, mid, node*2, index, dif);
		update(mid+1, end, node*2+1, index, dif);
    	
    }
   

}