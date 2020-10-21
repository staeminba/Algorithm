package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G_게임설치_탐욕 {
	
	static int K,N;
    static int[] cdFlag,num;
    static ArrayList<Integer> cd;
    static int result;
    static PriorityQueue<Integer>[] q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        q = new PriorityQueue[1001];

        for (int i = 1; i <= 1000; i++) {
            q[i] = new PriorityQueue<Integer>();
        }
        cd = new ArrayList<>();
        cdFlag = new int[1001];
        num = new int[N+1];

        st = new StringTokenizer(br.readLine());

        int pos = 1;
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            num[i] = n;
            q[n].add(i);
            if(cdFlag[n] == 0 && cd.size() < K) { //현재 배열에 없으면
                cd.add(n);
                q[n].poll();
                cdFlag[n] = 1;
                pos = i;
            }else if(cdFlag[n] == 1 && cd.size() < K) { //현재 배열에 있지만 cd롬이 안찼으면
            	q[n].poll();
            }
        }
        if(pos < K){
            System.out.println("0");
            return;
        }

        for (int i = pos+1; i <= N; i++) {
            //System.out.println(" i : " + i + " cdFlag[i] : " + cdFlag[i] +" cd.indexOf(cdFlag[i]): " + cd.indexOf(cdFlag[i]));
            if(cdFlag[num[i]] == 0){
                pos = getLast(cdFlag[i]);
                //System.out.println("pos : " + pos);
                cdFlag[cd.get(pos)] = 0;
                cd.set(pos, num[i]);
                cdFlag[num[i]] = 1;
                result++;
            }
            q[num[i]].poll();
        }
        System.out.println(result);
    }

    private static int getLast(int num) {
        int max = 0;
        int pos = 0;
        for (int i = 0; i < K ; i++) {
            if(q[cd.get(i)].isEmpty()){
                return i;
            }else{
                if(q[cd.get(i)].peek() > max){
                    max = q[cd.get(i)].peek();
                    pos = i;
                }
            }
        }
        //System.out.println("max : " + max);
        return pos;
    }
}