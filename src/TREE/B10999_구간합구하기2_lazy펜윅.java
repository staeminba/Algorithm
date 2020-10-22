package TREE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class B10999_�����ձ��ϱ�2_lazy���� {
 
	
	static int N, M, K;
    static long arr[];
    static long mul[];
    static long add[];
    static long lazySum[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Long> list = new ArrayList<>();

        arr = new long[N + 1];
        mul = new long[N + 1];
        add = new long[N + 1];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
            int r=i, l=i;
            long p= arr[i];                                  //4���� 7���� 3��ŭ ����
            range_update(l,r,p);
        }

        for (int i = 1; i <= M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int d = Integer.parseInt(st.nextToken());
                int l=b, r=c, p=d;
                range_update(l,r,p);//4���� 7���� 3��ŭ ����
            }
            if (a == 2) {
                long result = 0;

                result += sum(c) - sum(b-1);

                bw.write(result+"\n");
            }
        }
            bw.flush();
            bw.close();

    }

    static void range_update(int l, int r, long by) {
        update(l, by, -by*(l-1));
        update(r+1, -by, by*r);
    }


    static void update(int i, long a, long b) {               //a�� ���, b�� ���
        while(i<=N) {
            mul[i]+=a;                                      //����� �����ϴ� ����Ʈ��
            add[i]+=b;                                      //����� �����ϴ� ����Ʈ��
            i+=(i&-i);
        }
    }
    static long sum(int i) {
        long x=i, a=0, b=0;
        while(i>0) {
            a+=mul[i];
            b+=add[i];
            i-=(i&-i);
        }
        return a*x+b;                                       //���*X+��� ����
    }

}