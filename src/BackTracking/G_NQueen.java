package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_NQueen {
	
	static int N;
	static int result;
	static int[] arr;
	static int chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		go(0,0,0);//비트마스크 이용
		/*arr = new int[N+1];
		//queen(1);
*/		bw.write(Integer.toString(result)+"\n");
		bw.flush();
		bw.close();
	}
	private static void go(int num,int ld, int rd) {
		// TODO Auto-generated method stub
		System.out.println(num+","+ld+","+rd);
		System.out.println(2& ( 1<<1));
		if(num == N){
			result++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if((chk & (1 <<i)) != 0 || (ld & (1<<i)) != 0 || (rd & (1<<i)) != 0)
				continue;
			System.out.println("i : " + i);
			chk |= (1 << i);
			go(num + 1, (ld | (1 << i)) << 1, (rd | (1 << i)) >> 1);
			chk &= ~(1 << i);
		}
	}
	
	


}