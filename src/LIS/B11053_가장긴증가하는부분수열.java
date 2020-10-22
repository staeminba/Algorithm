package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B11053_����������ϴºκм��� {
 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		
		int[] dp = new int[t+1];
		int[] arr = new int[t+1];
		    
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= t; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	    int n, i, j, max = 0;
	    Arrays.fill(dp, 1); // �ڽŸ� ������ �κм����� �������������̶�� �� �� �����Ƿ� '1'�� �ʱ�ȭ
	    for(i = 1; i <= t; i++){
	    	for(j = 1; j <= i; j++){
	    		if(arr[i] <= arr[j]) continue; // 'j'���� ���Ұ� 'i'���� ���Һ��� ũ�� j���� ���Ҵ� �������������� ���Ե��� �ʴ´�.
	    		dp[i] = Math.max(dp[i], dp[j]+1);
	    	}
	    	max = Math.max(max, dp[i]); // ������������ �߿����� ���̰� ���� �� ���� ã�´�.
	    }
	    System.out.println(max);
	}
}
