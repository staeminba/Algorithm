package Implements;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_DDR {
	static int N,M;
    static ArrayList<Edge> list;
    static class Edge{
        int num;
        long time;
        public Edge(int num,long time){
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            list.add(new Edge(n,t));
        }
        list.sort((Edge a, Edge b) -> (int)(a.time-b.time == 0 ? a.num - b.num : a.time-b.time));
        Long temp = list.get(0).time;
        int tempNum = 0;
        int cnt = 0;
        /*for (Edge  e : list) {
            System.out.println(e.num + " : " + e.time);
        }*/
        for (Edge  e : list) {
            //System.out.println(e.num + " : " + e.time + " " + temp) ;
            if(e.time == temp){
                if((tempNum & (1 << e.num)) == 0){
                    tempNum  = 1 << e.num;
                    cnt++;
                }
                //System.out.println(e.time + " Cnt : " + cnt);
                if(cnt > 2){
                    bw.write("0\n");
                    bw.flush();
                    bw.close();
                    return;
                }
            }else{
                temp = e.time;
							tempNum  = 1 << e.num;
                cnt = 1;
            }
        }
        bw.write("1\n");
        bw.flush();
        bw.close();
    }


}
