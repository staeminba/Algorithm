package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class 와일드카드_Trie {

	static int N;
	static String[] str;
	 
	static TrieNode root;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 알파벳 사이즈
    static final int ALPHABET = 26;
 
    // 트라이 노드
 
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET];
 
        // isEndOfWord 가 true면은 실제 존재하는 노드다.
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
- children 자식 노드를 가진다 이때 하나의 노드는 알파벳의 수만큼 가질수 있다.
- isEndOfWord -> 현재노드가 끝으로 단어가 끝나는지 check한다.
- 생성자 Node를 생설할때 children[ALPHABET]은 null 값으로 초기화해준다.
static TriNode root 는 최상단의 노드이다 모든 노드들의 시작점*/
 
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
 
        // for이 다놀고나면 가장 끝에 노드까지 다만들어진다.
        // pCrawl 은 end 노드를 가리킬네니 true값으로 바꿔준다.
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