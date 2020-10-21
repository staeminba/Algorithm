package 순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 신에게는아직12척의배가있사옵니다 {
	
	static String String;
	static int[] arr;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	String = br.readLine();
    	
    	int result = 0;
    	for (int i = 1; i <= String.length(); i++) {
    		arr = (getPi(String.substring(String.length()-i, String.length())));  //KMP 함수의 반환값 저장	
    		for (int num : arr) {
    			result = Math.max(result, num);
    		}
		}
		bw.write(result+"\n");

    	bw.flush();bw.close();
    }

    public static int[] getPi(String pattern) {  // 접두사와 접미사 매칭 Count
		int LenOfPattern = pattern.length();     // 찾을 Pattern's Length
		int[] pi = new int[LenOfPattern];
		int j = 0;
		for (int i = 1; i < LenOfPattern; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = pi[j-1];
			if(pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;
		}
		return pi;     // pi[] 반환
	}
	

}