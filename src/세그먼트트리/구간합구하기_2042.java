package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class 구간합구하기_2042 {
 

	static int arr[];
	static long tree[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		ArrayList<Long> list = new ArrayList<>();
		
		arr = new int[1000000];
		tree = new long[3000000];
		
		for(int i = 0; i<N; i++){
			token = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(token.nextToken()); 
		}
		
		init(0,N-1,1);
		
		for(int i = 0; i<M+K; i++){
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());
			
			if(a == 1){
				long temp = c-arr[b-1];
				arr[b-1] = c;
				update(0,N-1,1,b-1,temp);
			}
			
			if(a == 2){
				list.add((sum(0,N-1,1,b-1,c-1)));
			}
		}
		
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public static long init(int start, int end, int node){
		
		if(start == end){
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node * 2+1);
	}
	
	public static long sum(int start, int end, int node, int left, int right){
		
		if(left > end || right < start){
			return 0;
		}
		if(left <= start && end <= right){
			return tree[node];
		}
		
		int mid = (start+end)/2;
		
		return sum(start, mid, node*2, left, right)+sum(mid+1, end, node*2+1, left, right);
	}
	
	public static void update(int start, int end, int node, int index, long dif){
		if(index < start || index > end)return;
		
		tree[node] += dif;
		
		if(start == end)return;
		
		int mid = (start+end)/2;
		
		update(start, mid, node*2, index, dif);
		update(mid+1, end, node*2+1, index, dif);
	}
}
