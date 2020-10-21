package Implements;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_½Ã°øÀÇÆøÇ³¼ÓÀ¸·Î {
static int teamPick[];
	
	static int result;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        teamPick = new int[101];
        int num  = st.countTokens();

        for (int i = 0; i < num; i++) {
        	int temp = Integer.parseInt(st.nextToken());
        	teamPick[temp] = 1;
		}
        
        st = new StringTokenizer(br.readLine());
        num  = st.countTokens();
        for (int i = 0; i < num; i++) {
        	int temp = Integer.parseInt(st.nextToken());
        	if(teamPick[temp] != 1)
        		result++;
		}
        System.out.println(result);
    }

}