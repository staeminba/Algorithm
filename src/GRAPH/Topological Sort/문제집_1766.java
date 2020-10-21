package 위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 문제집_1766 {

	static int N, M;
	static int a, b;
	static int[] arr;
	static int[] cnt;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> result;
	
	static class Edge{
		int now;
		int next;
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		result = new ArrayList<Integer>();
		arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			arr[b]++;
		}
		
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		for (int i = 1; i <= N; i++) {
			if(arr[i] == 0){
				que.offer(i);
			}
		}
		
		while(!que.isEmpty()){
			int num = que.poll();
			result.add(num);
			for (int temp : list[num]) {
				if(--arr[temp] == 0){
					que.add(temp);
				}
			}
		}

		for (int i = 0; i <result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}

}
