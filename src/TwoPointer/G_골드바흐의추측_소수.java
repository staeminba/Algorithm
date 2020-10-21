package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G_골드바흐의추측_소수 {

	static int N;
	static int num;
	static int arr[];
	static ArrayList<Integer> list;
	static Edge res;
	
	static class Edge{
		int x,y;
		public Edge(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[1000001];
        list = new ArrayList<>();
        init();
        for (int i = 1; i <= N; i++) {
        	res = new Edge(0,0);
			num = Integer.parseInt(br.readLine());
	        solve();
	        System.out.println(res.x + " " + res.y);
		}
     

    }

	private static void init() {
		// TODO Auto-generated method stub
		for (int i = 2; i*i <= 1000000; i++) {
			if(arr[i] == 1) //현재 수가 지워져잇으면
				continue;
			for (int j = i*i; j <= 1000000; j+=i) {
				arr[j] = 1;
			}
		}
		for (int i = 2; i <= 1000000; i++) {
			if(arr[i] == 0){
				list.add(i);
			}
		}
	}

	private static void solve() {
		// TODO Auto-generated method stub
		int l = 0, r = list.size()-1;
		while(l <= r){
			int sum = list.get(l) + list.get(r);
			//System.out.println(sum + " : " + num);
			if(sum > num)
				r--;
			else if(sum < num)
				l++;
			else{
				//System.out.println(l + " " + r);
				res.x = list.get(l);res.y = list.get(r);
				l++;r--;
			}
				
		}
	}

}