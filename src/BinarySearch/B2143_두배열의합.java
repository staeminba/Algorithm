package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2143_두배열의합 {
	
	static int T;
	static int n, m;
	static Long arr1[], arr2[];
	static ArrayList<Long> list1 = new ArrayList<Long>();;
	static ArrayList<Long> list2 = new ArrayList<Long>();;

	static int start, end;
	static long ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		arr1 = new Long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				arr1[i] = Long.parseLong(st.nextToken());
			} else {
				arr1[i] = arr1[i - 1] + Integer.parseInt(st.nextToken());
			}
		}
		
		/*for (int i = 0; i < n; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();*/

		for (int i = 1; i <= n; i++) {
			list1.add(arr1[i-1]);
			for (int j = i; j < n; j++) {
				list1.add(arr1[j] - arr1[j-i]);
			}
		}
		Collections.sort(list1);
		
		/*for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i)+ " ");
		}
		System.out.println();*/

		m = Integer.parseInt(br.readLine());
		arr2 = new Long[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			if (i == 0) {
				arr2[i] = Long.parseLong(st.nextToken());
			} else {
				arr2[i] = arr2[i - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= m; i++) {
			list2.add(arr2[i-1]);
			for (int j = i; j < m; j++) {
				list2.add(arr2[j] - arr2[j-i]);
			}
		}
		Collections.sort(list2);
		Collections.reverse(list2);
	/*	for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+ " ");
		}
		System.out.println();*/

		solve();
		System.out.println(ans);

	}

	private static void solve() {
		// TODO Auto-generated method stub
		start = 0;
		end = 0;
		long sum = 0;
		while (start < list1.size() && end < list2.size()){
			//System.out.println("[" + start + "," + end+"] " + "list1.get(start) : " + list1.get(start) + " list2.get(end) : " + list2.get(end));
			sum = list1.get(start) + list2.get(end);
			if (sum == T) {
				long ll=1;
				long rr=1;
				start++;
				end++;
				while(start<list1.size() && list1.get(start).equals(list1.get(start-1)) ) {
					//System.out.println("!11");
					ll++;
					start++;
				}
				while(end<list2.size() && list2.get(end).equals(list2.get(end-1)) ) {
					//System.out.println("!2221");
					rr++;
					end++;
				}
				ans += ll*rr;
				//System.out.println("ans : " + ans);
			} else if (sum > T) {
				end++;
			} else {
				start++;
			}
		}
	}
}
