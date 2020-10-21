package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G_¸ÀÀÖ´Â»ï°ã»ì_Å½¿å {
	
	static char[] str;
	static int N;
	static int[] arr;
	static int result;
	static int Max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			Max = Math.max(num, Max);
			arr[num] += 1;
		}
        
        for (int i = 0; i <= Max; i++) {
			if(arr[i] == 1){
				result += 1;
			}else if(arr[i] > 1){
				if(result <= i){
					result = Math.min(result + arr[i], i+1);
				}
			}
			//System.out.println(arr[i] + " " + result);
		}
        System.out.println(result);
        
    }

}