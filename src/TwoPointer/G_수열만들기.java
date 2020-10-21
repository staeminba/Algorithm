package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_수열만들기 {
	
	static int N,M;
	static int[] arr1,arr2;
	static int sum;
	static int result;
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	result = 0;
    	arr1 = new int[N+1];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
    		arr1[i] = Integer.parseInt(st.nextToken()); 
    		sum += arr1[i];
		}
    	
    	M = Integer.parseInt(br.readLine());
    	arr2 = new int[M+1];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= M; i++) {
    		arr2[i] = Integer.parseInt(st.nextToken()); 
    		sum -= arr2[i];
		}
    	
    	if(sum != 0){
    		System.out.println(-1);
    		return;
    	}
    	
    	int fLeft = 1, sLeft = 1; 
    	
    	while(fLeft <= N){
    		//System.out.println("arr1["+fLeft+"] : " + arr1[fLeft] + " arr2["+sLeft+"] : " + arr2[sLeft]);
    		if(arr1[fLeft] < arr2[sLeft]){ //첫 배열의 수가 작으면
    			arr1[fLeft+1] += arr1[fLeft++];
    		}else if(arr1[fLeft] > arr2[sLeft]){ //두번째 배열의 수가 작으면
    			arr2[sLeft+1] += arr2[sLeft++];
    		}else{
    			fLeft++;
    			sLeft++;
    			result++;
    		} 
    	}
    	System.out.println(result);
	}
	

}
	