package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class G_����ٷξ˱�_�÷��̵� {
 
	static int N,M,Q;
    static int[] dist;
    static int[][] arr;
    static final int INF = 100000000;

    // ��Ȧ�� ��ȯ�� �ϴ��� ���ϴ����� ���� ����
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // ������ ���� (1��N��500)
        M = Integer.parseInt(st.nextToken()); // ������ ���� (1��M��2500)

        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j)
                    arr[i][j] = 0;
                else
                    arr[i][j] = INF;
            }
        }




        for(int i=0; i<M; i++){ //���ΰ� ����
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // ��������
            int E = Integer.parseInt(st.nextToken()); // ��������

            arr[S][E] = 1;
        }


        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                for (int k = 1; k <= N ; k++) {
                    arr[j][k] = Math.min(arr[j][k] , arr[j][i] + arr[i][k]);
                }
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= Q ; i++) {
            st = new StringTokenizer(br.readLine());
            int x  = Integer.parseInt(st.nextToken());
            int y  = Integer.parseInt(st.nextToken());
            if(arr[x][y] != INF && arr[y][x] == INF)
                System.out.println('O');
            else if(arr[x][y] == INF && arr[y][x] != INF){
                System.out.println('X');
            }else
                System.out.println("?");

        }
    }
}

