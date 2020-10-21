package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_행성분열기_중상 {
	
	static int N;
	static int arr[];
	static int cnt[];
	static Edge[] list;
	static Edge[] sort;
	public static class Edge{
		int num = 0;
		int pos = 0;
		
		public Edge(int num,int pos){
			this.num = num;
			this.pos = pos;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+1];
        cnt = new int[N+1];
        list = new Edge[N+1];
        sort = new Edge[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			Edge e = new Edge(num,i);
			list[i] = e;
			/*list[i].num = num;
			list[i].pos = i;*/
        }
        mergeSort(list , 0, N-1);
      
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
        	sb.append(cnt[i]+"\n");
		}
        System.out.println(sb.toString());
			
		
    }

	public static void mergeSort(Edge[] a, int low , int high) {
		// TODO Auto-generated method stub
		if(low < high){
			int mid = (low + high)/2;
			mergeSort(a, low ,mid);
			mergeSort(a, mid+1 ,high);
			merge(a,low,mid,high);
		}
	}

	public static void merge(Edge[] a, int low, int mid, int high) {
		// TODO Auto-generated method stub
		
		int l = low, r = mid+1;
		int pos = low;	
		while(l <= mid && r <= high){
			if(a[l].num <= a[r].num)
				sort[pos++] = a[l++];
			else{
				sort[pos++] = a[r];
				cnt[a[r++].pos] += mid-l+1;
			}
		}
		
		while(l<=mid){
			sort[pos++] = a[l++];
		}
		while(r<=high){
			sort[pos++] = a[r++];
		}
		for (int i = low ; i <= high ; i++) {
			a[i] = sort[i];
		}
	}


}