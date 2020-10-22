package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2661_좋은수열 {
	
	private static int N; 
	private static String str = null;


	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		add(1);
	}


	private static void add(int num) {
		// TODO Auto-generated method stub
		boolean tf = false;
		for (int i = 1; i <= 3; i++) {
			if(num == 1){
				str = i+"";
				add(num+1);
			}else{
				tf = correct();
				if(tf){
					if(num == N+1){
						System.out.println(str);
						System.exit(0);
					}else{
						str += (i+"");
						add(num+1);
					}
				}
			}
		}
		str = str.substring(0,num-2);
		return;
	}


	private static boolean correct() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= str.length()/2; i++) {
			for (int j = str.length(); j > str.length() - 1 - i; j--) {
				if(j - i -i < 0){
					continue;
				}
				if(str.substring(j-i,j).equals(str.substring(j-i-i,j-i))){
					return false;
				}
			}
		}
		return true;
	}


}