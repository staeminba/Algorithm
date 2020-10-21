package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G_비밀번호찾기 {
	
	static int N;
	static ArrayList<Integer> list;
	static int max,sec;
	
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	list = new ArrayList<>();
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		list.add(num);
		}
    	
    	Collections.sort(list,(num1,num2) -> num2-num1);
//    	for (Edge e : list) {
//			System.out.print(e.num + " ");
//		}
//    	System.out.println();
    	max = list.get(0);
    	findDiv();
    	Collections.sort(list,(num1,num2) -> num2-num1);
    	bw.write(list.get(0)+" " + max+"\n");
    	bw.flush();
    	bw.close();
	}

	private static void findDiv() {
		// TODO Auto-generated method stub
		int max = list.get(0);
		for (int i = 1; i*i <= max; i++) {
			if(max % i == 0){
				if(list.indexOf(i) != -1)
					list.remove(list.indexOf(i));
				if(list.indexOf(max/i) != -1)
					list.remove(list.indexOf(max/i));
			}	
		}
	}
	

}
	