package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_�̻�_Ž��� {
	
	static long N , result;
	static int M;
	static int[] cnt;
	static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = new int[66];
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) {
        	int num = Integer.parseInt(st.nextToken());
        	int n = (int)(Math.log10(num) / Math.log10(2));
        	//System.out.println("num : "+ num + " n : " + n);
        	++cnt[n];
        	result+= num;
		}
        int ans = 0;
        if(N > result){
        	System.out.println("-1");
        	return;
        }else{
        	for (int i = 0; i < 62; ++i) {
				if((int)(N & (1L<<i)) != 0){ 
					if(cnt[i] > 0){//i��° ��Ʈ�� �����ִٸ� 2^i ũ���� ���ڸ� �ְ� ���� ���ڵ��� ��� ��ģ��.
						--cnt[i];
					}else{//2^i ũ���� ���ڰ� ���� ��� 2^i ���� ū ���ڵ� �� ���� ���� ���ڸ� ������ ū ���ڸ� ä��
						while(i < 62 && cnt[i] == 0){
							++i;
							++ans;
							System.out.println("-------"+i + " " + cnt[i]);
						}
						--cnt[i];
						--i;
					}
				}
				//System.out.println(i + " " + cnt[i]);
				cnt[i+1] += cnt[i]/2;
			}
        	System.out.println(ans);
        }
    }

}