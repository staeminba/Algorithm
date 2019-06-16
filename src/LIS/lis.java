package proTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class lis {
 
    static int[] arr;
    static int[] dp;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N+1];
        dp=new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int index=1;
        while(st.hasMoreTokens()){
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        
        int max=0;
        for(int i=1; i<=N; ++i){
            max=Math.max(max, f(i));
        }
        
        System.out.println(max);
        br.close();
    }
    
    public static int f(int start){
        
        int ret =dp[start]; 
        if(ret>0) return ret;
        ret=1;
        for(int i=start+1; i<=N; ++i){
            if(arr[start]<arr[i]){
            ret=Math.max(ret, f(i)+1);
            
            }
        }
        return dp[start]=ret;    
    }
}

