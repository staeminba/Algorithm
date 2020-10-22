package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11266_단절점 {

	static int V,E;
	static ArrayList<Integer>[] list;
	static int[] cutArr;
	static int[] order;
	static int cnt = 1;
	static int result = 0;
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		order = new int[V+1];
		list = new ArrayList[V+1];
		cutArr = new int[V+1];
		
		
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 1; i <= V; i++) {
			if(order[i] == 0)
				dfs(i,true);
		}
		
		for (int a : cutArr) {
			if(a != 0)
				result++;
		}
		System.out.println(result);
		for (int i = 1; i <= V; i++) {
			if(cutArr[i] != 0)
				System.out.print(i + " ");
		}
		
	}
	
	public static int dfs(int v,boolean isRoot){
		int rootCnt = 0;
		order[v] = cnt++;
		int ret = order[v];
		
		for(int i = 0; i < list[v].size(); i++){
			int num = list[v].get(i);
			if(order[num] == 0){
				rootCnt++;
				
				int low = dfs(num,false);
				if(order[v] <= low && !isRoot){
					cutArr[v] = 1;
				}
			
				ret = Math.min(ret,low);
			}else
				ret = Math.min(ret,order[num]);
		}
		
		//루트 검사
        if(isRoot && 1 < rootCnt){
        	cutArr[v] = 1;
        }

        return ret;
	}
}