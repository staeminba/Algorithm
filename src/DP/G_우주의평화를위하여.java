package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_우주의평화를위하여 {
	
	static int N;
	static int arr[][];
	static int cnt;
		
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+1][N+1];
        
        StringTokenizer st = null;
        for (int i = 1; i <= N; i++) {
       		st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
        }
        solve(1,1,N);
        System.out.println(cnt);
    }

	private static void solve(int start,int end,int size) {
		// TODO Auto-generated method stub
		//System.out.println(start+","+end + " cnt : " + cnt + " size : " + size);
		int sNum = arr[start][end];
		boolean same = true;
		for (int i = 0 ; i < size ; i ++) {
			for (int j = 0 ; j < size ; j ++) {
				if(arr[i+start][j+end] != sNum){
					same = false;
					break;
				}
			}
		}
		if(same)
			++cnt;
		else{
			int temp = size/2;
			solve(start,end,temp);
			solve(start+temp,end,temp);
			solve(start,end+temp,temp);
			solve(start+temp,end+temp,temp);
		}
			
		return;
		
	}

}