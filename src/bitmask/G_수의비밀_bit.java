package bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_수의비밀_bit {
	
static int result;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        
        result = solve(num);
        if(result == 1)
        	System.out.println("Yes");
        else
        	System.out.println("No");
    }

	public static int solve(long num) {
		// TODO Auto-generated method stub
		if(num == (num & -num))
			return 1;
		else
			return 0;
	}
    
	/*public static int solve(long num) {
		// TODO Auto-generated method stub
		if(num % 2 == 0){
			return solve(num/2);
		}
		if(num == 1){
			return 1;
		}else
			return 0; 
	}*/

}