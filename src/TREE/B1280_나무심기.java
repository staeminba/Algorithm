package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class B1280_나무심기 {
 
	
	static long treeCnt[];
	static long treeDist[];
	static int N;
	static final int MAX = 2000000;
	static final int MOD = 1000000007;
	static long result = 1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		treeCnt = new long[MAX+1]; 
		treeDist = new long[MAX+1]; 

		N = Integer.parseInt(br.readLine());
				
		
		for(int i = 1; i<=N; i++){
			int temp = Integer.parseInt(br.readLine());
			temp++;
			if(i==1){
				updateCnt(temp,1);// 현재 위치 까지의 나무의 수
				updateDist(temp,temp);// 현재 위치 까지의 거리 합
			}else{
				long lCnt = sumCnt(temp -1);
				long rCnt = sumCnt(MAX) - sumCnt(temp);
				
				long lSum = sumDist(temp -1);
				long rSum = sumDist(MAX) - sumDist(temp);
				
				long temp1 = (lCnt*temp - lSum) % MOD;
		        long temp2 = (rSum - rCnt*temp) % MOD;
				
		        
		        long sum = 0;
                sum += (sumCnt(temp - 1)*temp - (sumDist(temp-1)))% MOD;;
                sum += ((sumDist(MAX) - sumDist(temp)) - (sumCnt(MAX) - sumCnt(temp))*temp)% MOD;;
                
				updateCnt(temp,1);// 현재 위치 까지의 나무의 수
				updateDist(temp,temp);// 현재 위치 까지의 거리 합
				result = (result*sum)%MOD;
			}
		}
		System.out.println(result);
	}
	
	public static long sumCnt(int x){
		int  ans = 0;
		for (int i = x; i > 0; i -= (i&-i)) {
	            ans += treeCnt[i];
	    }
	    return ans;
	}
	
	public static long sumDist(int x){
		long  ans = 0;
		for (int i = x; i > 0; i -= (i&-i)) {
	            ans += treeDist[i];
	    }
	    return ans;
	}
	
	public static void updateCnt(int index,int val){
		for (int i = index; i <= MAX; i += (i & -i)) {
			treeCnt[i] += val;
		}
	}
	
	public static void updateDist(int index,int val){
		for (int i = index; i <= MAX; i += (i & -i)) {
			treeDist[i] += val;
		}
	}
}
