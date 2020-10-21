package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class G_타임머신_벨만포드 {
 
	static int N,M,W;
    static int[] dist;
    static ArrayList<Edge> listA;
    static class Edge{
        int start;
        int end;
        int time;
        public Edge(int start, int end, int time){
            this.start = start;
            this.end = end;
            this.time = time;
        }

    }
    // 웜홀은 순환을 하는지 안하는지에 대한 문제
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        listA =  new ArrayList<>();
        N = Integer.parseInt(st.nextToken()); // 지점의 갯수 (1≤N≤500)
        M = Integer.parseInt(st.nextToken()); // 도로의 갯수 (1≤M≤2500)

        dist = new int [N+1];

        for(int i=0; i<M; i++){ //도로값 설정
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 시작지점
            int E = Integer.parseInt(st.nextToken()); // 도착지점
            int D = Integer.parseInt(st.nextToken()); // 시간
            listA.add(new Edge(S,E,D));
        }


        for(int i=0; i<N+1; i++){ //dist에 초기화값 세팅
            dist[i]=Integer.MAX_VALUE;
        }
        dist[1]=0;

        if(bellmanford()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
    static boolean bellmanford(){
        //V-1개 만큼 반복한다.
        for(int i=0; i<N; i++){
            for(int j=0; j<listA.size(); j++){
                //완화 과정 삽입 Relaxation
                //upper[a]<=upper[s]+w(s,a) 인지를 반복해서 검증
                int s = listA.get(j).start;
                int e = listA.get(j).end;
                int t = listA.get(j).time;
                if (dist[s] == Integer.MAX_VALUE)
                    continue;
                if(dist[e]>dist[s]+t){
                    if(i == N-1)
                        return false;
                    dist[e]=dist[s]+t;
                }

            }
        }

       /* //사이클 순환 확인
        for(int j=0; j<listA.size(); j++){
            int s = listA.get(j).getStart();
            int e = listA.get(j).getEnd();
            int t = listA.get(j).getTime();
            if(dist[e]>dist[s]+t){
                return false;
            }
        }*/
        return true;
    }
}

