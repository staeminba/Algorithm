package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class B12015_가장긴증가하는부분수열2 {
 

	static int N;
	static int ans = 1;
	static int[] arr;
	static int left,right;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+1];
        left = 0; right = -1;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	int l = 0; int r = right;
        	int mid;
        	while(l <= r){
        		mid = (l+r) >> 1;
        		if(arr[mid] >= num)
        			r = mid -1;
        		else
        			l = mid + 1;
        	}
        	if(r+1 > right)
        		right = r+1;
        	arr[r+1] = num;
		}
        System.out.println(right+1);
        
    }
}