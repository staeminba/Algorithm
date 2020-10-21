package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 검색엔진 {
	
	static int arr[][];
	static int visit[];
	static int order[];
	static int check[];
	static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        arr = new int[12][12];
        visit = new int[12];
        order = new int[12];
        check = new int[12];
        for (int i = 1; i <= 11; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= 11; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
		}
        int[] tc = new int[12];
        for (int i = 1; i <=  11; i++) {
			tc[i] = i;
			result += arr[i][i];
		}
        while(nextPermutation(tc)){
        	int temp = 0;
        	for (int i = 1; i <=  11; i++) {
    			temp += arr[i][tc[i]];
    		}
        	if(result < temp){
        		result = temp;
        		order =  tc.clone();
        	}
        }
        System.out.println(result);
        for (int i = 1; i <= 11; i++) {
        	System.out.print(order[i] + " ");
		}
        System.out.println();
      
        
    }
	/*private static void solve(int now, int sum) {
		// TODO Auto-generated method stub
		if(now == 12){
			if(result < sum){
				result = sum;
			
				for (int i = 1; i <= 11; i++) {
					order[i] = check[i];
				}
			}
			return;
		}
		
		for (int i = 1; i <= 11; i++) {
			if(visit[i] == 1)
				continue;
			visit[i] = 1;
			check[now] = i;
			solve(now+1, sum+arr[now][i]);
			check[now] = 0;
			visit[i] = 0;
		}
		
	}*/
	private static boolean nextPermutation(int[] tc) {
		// TODO Auto-generated method stub
		int i = 11;
		while(i > 1  && tc[i-1] >= tc[i])//맨 뒷자리 부터 조사하여 숫자가 올라가다 작아지는 위치를 찾는다.
			i--;
	
		if(i<=1)//처음이랑 같으면
			return false;
		
		int j = 11;
		while(j > 1 && tc[j] <= tc[i-1])
			j--;
		
		//swap
		int temp = tc[j];
		tc[j] = tc[i-1];
		tc[i-1] = temp;
		
		j = 11;
		while(i < j){
			temp = tc[j];
			tc[j] = tc[i];
			tc[i] = temp;
			i++;
			j--;
		}
		
		System.out.println(" i : " + i + " j : " + j);
		return true;
	}

}