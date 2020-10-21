package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경계근무 {
	
	static int N,M;
	static ArrayList<Integer> list;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int l = 0; int r = 1000000001;
		while(l<=r){
			System.out.println("l  : " + l + " r : " + r);
			int mid = (l+r) >> 1;
			int res = chk(mid);
			
			if(res > M)
				r = mid-1;
			else{
				result = Math.max(result, mid);
				l = mid+1;
			}
		}
		System.out.println(result);
	
	}

	private static int chk(int mid) {
		// TODO Auto-generated method stub
		int cur = 0;
		int res = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) - cur >= mid)
				cur = list.get(i);
			else
				res++;
		}
		return res;
	}
}
