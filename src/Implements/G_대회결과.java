package Implements;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G_대회결과 {
	static int N, M, Q;
	static int[][] arr;



	public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        Q = Integer.parseInt(st.nextToken());

	        arr = new int[N+1][M+1];

	        for (int i = 1; i <= Q; i++) {
	            st = new StringTokenizer(br.readLine());

	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            int c = Integer.parseInt(st.nextToken());
	            String d = st.nextToken();

	            if(d.equalsIgnoreCase("ac") && arr[a][b] <= 0){//맞춘경우
	               arr[a][b] *= -1;
	               arr[a][b] += c;
	            }else if(arr[a][b] <= 0){
	            	arr[a][b] -= 20;
	            }


	        }
	        for (int i = 1; i <= N; i++) {
	        	int cnt = 0 , sum = 0;
	        	for (int j = 1; j <= M; j++) {
					if(arr[i][j] > 0){
						cnt++;
						sum += arr[i][j];
					}
					
				}
	        	bw.write(i+"" + " " +cnt+""+ " " + sum+""+"\n");
			}
	        bw.flush();
	        bw.close();
	        
	    }
}
