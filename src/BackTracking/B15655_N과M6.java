package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15655_N°úM6 {
	static int M,N;
    static boolean[] visit;
    static int[] num;
    static int[] input;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M+1];
        st = new StringTokenizer(br.readLine());
        input = new int[N+1];
        for (int i = 1; i <= N ; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[N+1];
        Arrays.fill(visit, false);
        Arrays.sort(input);
        perm(0);
        System.out.println(sb.toString());



    }

    public static void perm(int r){
        //System.out.println("r : " + r);
        if(r==M) {
            for(int i = 1 ; i<=M ; i++) {
               sb.append(num[i] + " ");
            }
            sb.append("\n");
            return;
        }
        else{
            for(int i = 1; i <= N; i++){
                if(visit[i])
                    continue;
                if(num[r] > input[i])
                    continue;
                visit[i] = true;
                num[r+1] = input[i] ;
                perm(r+1);
                //System.out.println("r+!");
                visit[i] = false;
            }
        }
    }
}