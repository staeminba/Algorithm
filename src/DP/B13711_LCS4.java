package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B13711_LCS4 {

	static int N;
    static HashMap<Integer,Integer> map;
    static int[] a;
    static int[] b;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        StringTokenizer st;
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        dp = new int[N+1];
        a = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map.put(Integer.parseInt(st.nextToken()),i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = map.get(Integer.parseInt(st.nextToken()));
        }

        dp[1] = a[1];
        int now = 1;
        for (int i = 2; i <= N; i++) {
            if(a[i] > dp[now]){
                dp[++now] = a[i];
            }else{
                dp[lowerbound(i)] = a[i];
            }
        }

        System.out.println(now);

    }

    private static int lowerbound(int num) {
        // TODO Auto-generated method stub
        for (int i = 1; i <= dp.length; i++) {
            if(a[num] <= dp[i]){
                return i;
            }
        }
        return 0;
    }

}