package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * N-Queen 문제 bitmask 이용시 시간을 절반가까이 줄일수 있다.
 */
public class B9663_NQueen_일반 {
	
	static int N;
	static int result;
	static int[] arr;
	static int[] dx = {0,0,-1,1,-1,-1,1,1};
	static int[] dy = {-1,1,0,0,-1,1,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		queen(1);
		bw.write(Integer.toString(result)+"\n");
		bw.flush();
		bw.close();
	}
	private static void queen(int num) {
		// TODO Auto-generated method stub
		if(num == N+1){ //모든 행에 퀸을 배치했으면
			result++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			arr[num] = i; //열에 퀸을 배치
			if(isPossible(num))
				queen(num+1);
		}
		
	}
	private static boolean isPossible(int num) {
		// TODO Auto-generated method stub
		for (int i = 1; i < num; i++) {//퀸이 위치한 열이 겹칠떄
			if(arr[i] == arr[num])
				return false;
			else if(Math.abs(arr[i] - arr[num]) == num-i)
				return false;
		}
		
		return true;
	}


}