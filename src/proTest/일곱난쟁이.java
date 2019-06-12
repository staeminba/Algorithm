package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class ¿œ∞ˆ≥≠¿Ô¿Ã {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br;
    	br = new BufferedReader(new InputStreamReader(System.in));
    	int[] nan = new int[9];
    	for (int i = 0; i < 9; i++) {
			nan[i] = Integer.parseInt(br.readLine());
		}
    	Arrays.sort(nan);
    	
    	for (int i = 0; i < (1<<9); i++) {
    		int sum = 0;
			if(Integer.bitCount(i) == 7){
				for (int j = 0; j < 9; j++) {
					if(((1<<j)&i) >0){
						sum += nan[j];
					}
				}
				if(sum == 100){
					for (int j = 0; j < nan.length; j++) {
						if(((1<<j)&i) >0){
							System.out.println(nan[j]);
						}
					}
				}
			}
		}
    
    	
    }
	
}