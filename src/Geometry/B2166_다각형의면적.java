package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2166_다각형의면적 {
	static int N;
    static Edge first;
    static ArrayList<Edge> list;
    static class Edge{
        int x;
        int y;

        Edge(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());


        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Edge(x,y));



        }
        double sum = 0;

        for (int i = 1; i <= N; i++) {
            int j = i%N + 1;
            sum += (long)list.get(i-1).x * list.get(j-1).y - (long)list.get(j-1).x * list.get(i-1).y;
        }

        System.out.printf("%.1f",Math.abs(sum)/2);
    }


   

}