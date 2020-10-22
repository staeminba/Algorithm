package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class B11758_CCW {
	static class Edge{
        int x;
        int y;
        Edge(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Edge[] arr = new Edge[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Edge(x,y);

        }

        System.out.println(ccw(arr[0],arr[1],arr[2]));

    }

    public static int ccw(Edge e1, Edge e2, Edge e3){
        int result = (e1.x*e2.y + e2.x*e3.y + e3.x*e1.y) - (e2.x*e1.y + e3.x*e2.y + e1.x*e3.y);
        if(result > 0){
            result = 1;
        }else if(result < 0){
            result = -1;
        }

        return result;
    }


}
