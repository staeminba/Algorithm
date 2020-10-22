package MATH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10757_Å«¼öAB {
	static int[] result;
	static char[] b;
	static String str1,str2;
    public static void main(String[] args) throws IOException {
    	BufferedReader br;
    	br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	str1 = st.nextToken();
    	str2 = st.nextToken();
    	
    	result = new int[Math.max(str1.length(), str2.length())+1];
    	int maxLen = Math.max(str1.length(), str2.length());
    	int minLen = Math.min(str1.length(), str2.length());

    	int len = Math.max(str1.length(), str2.length());
    	StringBuilder sb = new StringBuilder();
    	for (int i = len ; i > 0; i--) {
    		int nowNum = i-1;
    		if(nowNum >= maxLen - minLen){
    			int temp = 0;
    			//System.out.println(nowNum + " , " + (nowNum - (maxLen - minLen)));
    			if(str1.length() > str2.length()){
		    		temp =  (str1.charAt(nowNum)-'0' + str2.charAt(nowNum - (maxLen - minLen)))-'0'+result[i];
    			}else{
    				temp =  (str2.charAt(nowNum)-'0' + str1.charAt(nowNum - (maxLen - minLen)))-'0'+result[i];
    			}
	    		if(temp >= 10){
	    			result[i] =  temp%10;
	    			if(i > 0)
	    				result[i-1] =  temp/10;
	    			else
	    				result[0] = 1;
	    		}else{
	    			result[i] =  temp%10;
	    		}
	    		//System.out.println(" i : " + i + " "  +result[i]);
    		}else{
    			if(str1.length() > str2.length()){
    				int temp = (str1.charAt(nowNum)-'0')+result[i];
    				//System.out.println("temp1 : " + temp);
	    			if(temp >= 10){
		    			result[i] =  (temp)%10;
		    			if(i > 0)
		    				result[i-1] +=  (temp)/10;
		    			else
		    				result[0] = 1;
		    		}else{
		    			result[i] =  temp;
		    		}
	    		}else{
	    			int temp = (str2.charAt(nowNum)-'0')+result[i];
	    			//System.out.println("temp2 : " + temp);
	    			if(temp >= 10){
		    			result[i] =  (temp)%10;
		    			if(i > 0)
		    				result[i-1] +=  (temp)/10;
		    			else
		    				result[0] = 1;
		    		}else{
		    			result[i] =  temp;
		    		}
	    		}
    			//System.out.println(" i : " + i + " "  +result[i]);
    		}
		}
    	for (int i = 0; i < result.length; i++) {
    		if(i == 0 && result[i] == 0)
    			continue;
    		else
    			System.out.print(result[i]);
		}
    	System.out.println();    	
    	
    
    	
    }
	
}