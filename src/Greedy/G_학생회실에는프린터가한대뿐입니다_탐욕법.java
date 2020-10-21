package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G_학생회실에는프린터가한대뿐입니다_탐욕법 {
	
	static int N;
	static ArrayList<Integer> list;
	static long result;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
        	int num = Integer.parseInt(st.nextToken());
			list.add(num);
		}
        Collections.sort(list);
      
        for (int i = 0; i < N; i++) {
			int num = list.get(i);
			//System.out.println("num : " + num + " (N-i+1) : " + (N-i+1));
			result += num;
			result += (N-i-1) * num;
		}
        System.out.println(result);
    }
}