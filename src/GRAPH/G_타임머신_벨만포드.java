package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class G_Ÿ�Ӹӽ�_�������� {
 
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
    // ��Ȧ�� ��ȯ�� �ϴ��� ���ϴ����� ���� ����
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        listA =  new ArrayList<>();
        N = Integer.parseInt(st.nextToken()); // ������ ���� (1��N��500)
        M = Integer.parseInt(st.nextToken()); // ������ ���� (1��M��2500)

        dist = new int [N+1];

        for(int i=0; i<M; i++){ //���ΰ� ����
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // ��������
            int E = Integer.parseInt(st.nextToken()); // ��������
            int D = Integer.parseInt(st.nextToken()); // �ð�
            listA.add(new Edge(S,E,D));
        }


        for(int i=0; i<N+1; i++){ //dist�� �ʱ�ȭ�� ����
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
        //V-1�� ��ŭ �ݺ��Ѵ�.
        for(int i=0; i<N; i++){
            for(int j=0; j<listA.size(); j++){
                //��ȭ ���� ���� Relaxation
                //upper[a]<=upper[s]+w(s,a) ������ �ݺ��ؼ� ����
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

       /* //����Ŭ ��ȯ Ȯ��
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

