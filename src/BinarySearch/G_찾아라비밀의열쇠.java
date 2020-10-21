package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G_찾아라비밀의열쇠 {
	
	static int N,K,C;
	static ArrayList<Integer> list;
	static int cnt;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
                
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	list.add(num);
		}
        Collections.sort(list);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	if(binarySearch(num))
        		cnt++;
        	if(cnt == C){
        		System.out.println("yes");
        		return;
        	}
		}
        System.out.println("no");
        
    }

	private static boolean binarySearch(int num) {
		// TODO Auto-generated method stub
		int l = 0; int r = list.size()-1;
		while( l <= r){
			int mid = (l+r)/2;
			int temp = list.get(mid);
			if(temp < num)
				l = mid+1;
			else if(temp > num)
				r = mid-1;
			else if(temp == num)
				return true;
		}
		return false;
	}

}