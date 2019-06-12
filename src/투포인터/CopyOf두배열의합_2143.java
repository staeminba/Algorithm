package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CopyOf두배열의합_2143 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long value = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		
		long arrA[] = new long[a];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) {
			arrA[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		
		long arrB[] = new long[b];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++) {
			arrB[i] = Long.parseLong(st.nextToken());
		}
		
		ArrayList<Long> listA = new ArrayList<Long>();
		ArrayList<Long> listB = new ArrayList<Long>();
		
		listA = Sum(listA, arrA, a);
		listB = Sum(listB, arrB, b);
		
		Collections.sort(listA);
		Collections.sort(listB);
		for (int i = 0; i < listA.size(); i++) {
			System.out.print(listA.get(i)+ " ");
		}
		System.out.println();
		for (int i = 0; i < listB.size(); i++) {
			System.out.print(listB.get(i)+ " ");
		}
		Collections.reverse(listB);
		System.out.println();
		int l=0, r=0;
		int SizeA = listA.size();
		int SizeB = listB.size();
		long ans=0;
		// listA는 앞에서 부터
		// listB는 뒤에서 부터 숫자를 차례대로 봐줍니다.
		while(l<SizeA && r<SizeB) {
			if(listA.get(l) + listB.get(r) == value) {
				long ll=1;
				long rr=1;
				l++;
				r++;
				while(l<SizeA && listA.get(l).equals(listA.get(l-1)) ) {
					ll++;
					l++;
				}
				while(r<SizeB && listB.get(r).equals(listB.get(r-1)) ) {
					rr++;
					r++;
				}
				ans += ll*rr;
			} else if(listA.get(l) + listB.get(r) > value) {
				r++;
			} else {
				l++;
			}
		}
		System.out.println(ans);
	}
	// 인접한 배열의 숫자들을 다 더해서 ArrayList에 넣어줍니다.
	public static ArrayList<Long> Sum(ArrayList<Long> list, long arr[], int size) {
		for(int i=0; i<size; i++) {
			long sum=0;
			for(int j=i; j<size; j++) {
				sum += arr[j];
				list.add(sum);
			}
		}
		
		return list;
	}
}