package LIS;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class B1208_부분수열의합2 {
 

	static int N,S;
    static ArrayList<Integer> list1,list2;
    static long res;
    static ArrayList<Integer> sort1;
    static ArrayList<Integer> sort2;
    static int l,r;
    static long lCnt,rCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        sort1 = new ArrayList<>();
        sort2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=N; i++) {
            if((i & 1) == 0)//짝수면
                list1.add(Integer.parseInt(st.nextToken()));
            else
                list2.add(Integer.parseInt(st.nextToken()));
        }
        for (int j = (1<<list1.size()); j > 0 ; j--) {
            int sum = 0;
            for (int i = 0; i < list1.size(); i++) {
                if((j & (1 << i)) == 0){
                    sum += list1.get(i);
                }
            }
            sort1.add(sum);
        }

        sort1.sort((a, b)-> a - b);

        for (int j = (1<<list2.size()); j > 0 ; j--) {
            int sum = 0;
            for (int i = 0; i < list2.size(); i++) {
                if((j & (1 << i)) == 0)
                    sum += list2.get(i);
            }
            sort2.add(sum);
        }
        sort2.sort((a, b)-> a - b);

        long ans = find();
        System.out.println(S == 0 ? ans-1 : ans);
	/*	for (int n : sort1) {
			System.out.print(n + " ");
		}
		for (int n : sort2) {
			System.out.print(n + " ");
		}
		System.out.println();*/



    }

    private static long find() {
        // TODO Auto-generated method stub
        l = 0;
        r = sort2.size()-1;

        while(l < sort1.size() && r >= 0){
        	int leftValue =  sort1.get(l);
            int rightValue = sort2.get(r);
            long sum = leftValue + rightValue;
            if(sum == S){
                lCnt = 0;
                rCnt = 0;
                lowerBound();
                upperBound();
                res += (lCnt) * (rCnt);
               // System.out.println("lCnt : " + lCnt + " rCnt : " + rCnt + " res : " + res);



            }else if(sum < S)
                l++;
            else
                r--;

        }
        return res;
    }

    private static void lowerBound() {
        // TODO Auto-generated method stub
        int temp = sort1.get(l);
        for (int i = l; i < sort1.size(); i++) {
            if(sort1.get(i) > temp ){
                return;
            }
            l++;
            lCnt++;
        }
        return;
    }

    private static void upperBound() {
        // TODO Auto-generated method stub
        int temp = sort2.get(r);
        for (int i = r; i >= 0; i--) {
            if(sort2.get(i) < temp ) {
                return;
            }
            r--;
            rCnt++;
        }
        return;
    }
}
