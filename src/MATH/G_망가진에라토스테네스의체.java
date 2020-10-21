package MATH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G_망가진에라토스테네스의체 {
	static long N;
	static long A,B;
	static int res = 1;
	static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        if(N == 1){
        	System.out.println("0");
        	return;
        }
        
        if(!isPrime(N)){
	        if(isPrime(A) && isPrime(B))
	        	res = 1;
	        else
	        	res = 0;
        }
        System.out.println(res);
    }

	private static boolean isPrime(long num) {
		// TODO Auto-generated method stub
		for (long i = 2; i*i <= num; i++) {
			if(num % i == 0){
				A = i;
				B = (num/i);
				flag = true;
				return false;
			}
		}
		return true;
	}


}
