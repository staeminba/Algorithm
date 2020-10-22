package GRAPH;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

 
public class B1697_¼û¹Ù²ÀÁú_bfs {
	static int t, n, m, a, b, c, startc;
	static long Solution;

	static long[] citytime;
	static long[] visited;
	static long[][] info;

	static lineinfo[] bus;

	static boolean minustime = false;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// t = Integer.parseInt(st.nextToken());
		//
		// for(int tc = 1; tc <= t ; tc++){
		//
		//
		//
		// }
		minustime = false;

		n = Integer.parseInt(st.nextToken());
		// System.out.println("n ==>> " + n);
		m = Integer.parseInt(st.nextToken());

		citytime = new long[n + 1];

		Arrays.fill(citytime, Long.MAX_VALUE);
		citytime[1] = 0;

		// visited = new long[n+1];
		// info = new long[n+1][n+1];

		bus = new lineinfo[m];

		for (int bline = 0; bline < m; bline++) {
			st = new StringTokenizer(br.readLine());

			bus[bline] = new lineinfo(Long.parseLong(st.nextToken()),
					Long.parseLong(st.nextToken()), Long.parseLong(st
							.nextToken()));

		}

		Arrays.sort(bus, new compa());

		for (int i = 0; i < n - 1; i++) {

			for (int bline = 0; bline < m; bline++) {
				if (citytime[(int) bus[bline].scity] == Long.MAX_VALUE) {
					continue;
				}
				citytime[(int) bus[bline].tcity] = Math.min(
						citytime[(int) bus[bline].scity] + bus[bline].time,
						citytime[(int) bus[bline].tcity]);
				// System.out.println("citytime["+bus[bline].tcity+"] ==> " +
				// citytime[(int)bus[bline].tcity]);
			}
		}

		for (int bline = 0; bline < m; bline++) {
			if (citytime[(int) bus[bline].scity] == Long.MAX_VALUE) {
				continue;
			}
			if (citytime[(int) bus[bline].tcity] > citytime[(int) bus[bline].scity]
					+ bus[bline].time) {
				minustime = true;
				break;
			}

		}

		if (minustime) {
			System.out.println(-1);
		} else {
			for (int bline = 2; bline <= n; bline++) {
				if (citytime[bline] == Long.MAX_VALUE) {
					System.out.println(-1);
				} else {
					System.out.println(citytime[bline]);
				}
			}
		}

	}

	static class compa implements Comparator<lineinfo> {

		@Override
		public int compare(lineinfo bus1, lineinfo bus2) {
			// TODO Auto-generated method stub

			if (bus1.scity == bus2.scity)
				return (int) (bus1.tcity - bus2.tcity);

			return (int) (bus1.scity - bus2.scity);
		}

	}

	static class lineinfo {
		long scity;
		long tcity;
		long time;

		lineinfo(long scity, long tcity, long time) {
			this.scity = scity;
			this.tcity = tcity;
			this.time = time;
		}

		@Override
		public String toString() {
			return "[[ start : " + this.scity + " / tocity : " + this.tcity
					+ " / time : " + this.time + " ]]";
		}
	}

}
