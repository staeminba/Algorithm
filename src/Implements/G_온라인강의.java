package Implements;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_온라인강의 {
	 public static void main(String[] args) throws IOException {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String time = br.readLine();
	        int HH = Integer.parseInt(time.split(":")[0]);
	        int MM = Integer.parseInt(time.split(":")[1]);
	        
	        
	        String claz = br.readLine();
	        int cHH = Integer.parseInt(claz.split(":")[0]);
	        int cMM = Integer.parseInt(claz.split(":")[1]);
	        
	        MM += HH*60;
	        cMM += cHH*60;
	       // System.out.println(MM + " " + cMM);
	        if(MM > cMM || cMM - MM > 10)
	        	System.out.println("0");
	        else
	        	System.out.println("1");
	        return;
	        	
	    }

	}
