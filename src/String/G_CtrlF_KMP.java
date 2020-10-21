package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_CtrlF_KMP {

	static String String,Pattern;
	static ArrayList<Integer> list;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	String = br.readLine();
    	Pattern = br.readLine();
    	
    	list = KMP(String, Pattern);  //KMP �Լ��� ��ȯ�� ����
		int size = list.size();                          // ã�� ������ ����� ������ ����
        
		for(int i=0; i<size; i++) {                      // List�� size��ŭ �ش� �ε����� ����Ѵ�
			bw.write(list.get(i)+1+"\n");
		}

    	bw.flush();bw.close();
    }

    public static int[] getPi(String pattern) {  // ���λ�� ���̻� ��Ī Count
		int LenOfPattern = pattern.length();     // ã�� Pattern's Length
		int []pi = new int[LenOfPattern];        // pi[] �Ҵ�
		int j = 0;                               // ������ Ž���� �ε���
		
		for(int i=1; i<LenOfPattern; i++) {      // i = 1���� 
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) { // KMP�˰���, ��Ī�Ǵ� �� �ǳʶڴ�
				j = pi[j-1];                                         // j�� ���Ҵ� (�ǳ� ��)
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {            // ���λ�� ���̻簡 ���ٸ�
				pi[i] = ++j;                                         // �ش� �ε��� ī��Ʈ  (����)
			}
		}
		return pi;     // pi[] ��ȯ
	}
	

	public static ArrayList<Integer> KMP(String str, String pattern) {  // ��Ī�Ǵ� str�� ArrayList�� ����
		
		ArrayList<Integer> temp = new ArrayList<>();      // ��Ī�� str�� ������ ArrayList
		int [] pi = getPi(pattern);                       // ã�� ������ ���λ�� ���̻簡 ī��Ʈ�� �迭 �ҷ��´�
		int LenOfStr = str.length();                      // ���� str�� ����
		int LenOfPattern = pattern.length();              // ã�� pattern�� ����
		int j = 0;                                        // pattern�� Ž����ų �ε���
		
		for(int i=0; i<LenOfStr; i++) {                   // str�� 0��° (���� ó������)  Ž��
			while(j > 0 && str.charAt(i)!= pattern.charAt(j)) {    // KMP �˰����� �ٽ�
				j = pi[j-1];                                       // j ���Ҵ� (�ǳ� �ڴ�)
			}
			if(str.charAt(i)== pattern.charAt(j)) {               // ���ڰ� ���� ��
				if(j== LenOfPattern-1) {                           // �ش� �ε����� ������ ���� ��ġ? �׷� ��Ī ����!
					temp.add(i-LenOfPattern+1);                    // ã�� ������ list�� ������� �ִ´�
					j = pi[j];                                     // j �ʱ�ȭ
				}else {                                   // �ش� �ε����� ������ ���� ��ġ���� ������ �� ã�ƾ� ��!
					j++;                                  // Ž�� �ε��� ����!
				}
			}
		}
		return temp;                                       // ��Ī�� ������ ����� list ��ȯ
	}
}