package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class G_경품추천 {
	
	static int N,M;
	static HashMap<Long,Long> map;
   

	 public static void main(String[] args) throws IOException {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        
	        map = new HashMap<>();
	        
	        st = new StringTokenizer(br.readLine());
	        for (int i = 1; i <= N; i++) {
	        	long n = Long.parseLong(st.nextToken());
	        	long res = 0;
	        	res = map.get(n) == null ? 1 : map.get(n)  + 1;
				map.put(n, res);
			}
	        
	        st = new StringTokenizer(br.readLine());
	        for (int i = 1; i <= M; i++) {
	        	long m = Long.parseLong(st.nextToken());
				bw.write((map.get(m) == null ? 0 : map.get(m)) + " ");
	        }
	        bw.flush();
	        bw.close();
	    }

	   
	}
