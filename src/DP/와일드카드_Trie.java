package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class ���ϵ�ī��_Trie {

	static int N;
	static String[] str;
	 
	static TrieNode root;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// ���ĺ� ������
    static final int ALPHABET = 26;
 
    // Ʈ���� ���
 
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET];
 
        // isEndOfWord �� true���� ���� �����ϴ� ����.
        // end of a word
        boolean isEndOfWord;
        int cnt;
 
        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET; ++i)
                children[i] = null;
        }
 
    }
    /*TrieNode Class
- children �ڽ� ��带 ������ �̶� �ϳ��� ���� ���ĺ��� ����ŭ ������ �ִ�.
- isEndOfWord -> �����尡 ������ �ܾ �������� check�Ѵ�.
- ������ Node�� �����Ҷ� children[ALPHABET]�� null ������ �ʱ�ȭ���ش�.
static TriNode root �� �ֻ���� ����̴� ��� ������ ������*/
 
    static void insert(String key) {
        int level;
        int length = key.length();
        int index;
 
        TrieNode pCrawl = root;
 
        for (level = 0; level < length; ++level) {
 
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null){
            	cnt++;
                pCrawl.children[index] = new TrieNode();
             }
            pCrawl = pCrawl.children[index];
        }
 
        // for�� �ٳ���� ���� ���� ������ �ٸ��������.
        // pCrawl �� end ��带 ����ų�״� true������ �ٲ��ش�.
        pCrawl.isEndOfWord = true;
    }
 
    static boolean search(String key) throws IOException {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
 
        for (level = 0; level < length; ++level) {
            index = key.charAt(level) - 'a';
 
            if (pCrawl.children[index] == null)
                return false;
            bw.write(key);
            pCrawl = pCrawl.children[index];
        }
 
        return (pCrawl != null && pCrawl.isEndOfWord);
    }
    
    static boolean search2(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
 
        for (level = 0; level < length; ++level) {
            index = key.charAt(level) - 'a';
 
            if (pCrawl.children[index] == null)
                return false;
 
            pCrawl = pCrawl.children[index];
        }
 
        return (pCrawl != null && pCrawl.isEndOfWord);
    }



	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cnt = new int[28];
		str = new String[N+1];
		for (int i = 1; i <= N; i++) {
			str[i] = br.readLine();
			root = new TrieNode();
			insert(str[i]);
		}
		
		boolean ans = true;
		 
		for (int i = 1; i <= N; i++) {
            search(str[i]);
        }
		bw.flush();bw.close();
	}

}