package Implements;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G_¹®´Ü¼Ó {
static int teamPick[];
	
static int N;
static Stack<Integer> stack;
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    stack = new Stack<Integer>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N*2; i++) {
		int num = Integer.parseInt(st.nextToken());
		if(num > 0){
			stack.add(num);
		}else if(num < 0){
			if(stack.isEmpty()){
				System.out.println("no");
				return;
			}
			int top = stack.pop();
			if(top != -num){
				System.out.println("no");
				return;
			}
		}
	}
    if(stack.size() == 0)
    	System.out.println("yes");
    else
    	System.out.println("no");
}

}