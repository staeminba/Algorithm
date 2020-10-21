package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class �ſ��Դ¾���12ô�ǹ谡�ֻ�ɴϴ� {
	
	static String String;
	static int[] arr;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	String = br.readLine();
    	
    	int result = 0;
    	for (int i = 1; i <= String.length(); i++) {
    		arr = (getPi(String.substring(String.length()-i, String.length())));  //KMP �Լ��� ��ȯ�� ����	
    		for (int num : arr) {
    			result = Math.max(result, num);
    		}
		}
		bw.write(result+"\n");

    	bw.flush();bw.close();
    }

    public static int[] getPi(String pattern) {  // ���λ�� ���̻� ��Ī Count
		int LenOfPattern = pattern.length();     // ã�� Pattern's Length
		int[] pi = new int[LenOfPattern];
		int j = 0;
		for (int i = 1; i < LenOfPattern; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = pi[j-1];
			if(pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;
		}
		return pi;     // pi[] ��ȯ
	}
	

}