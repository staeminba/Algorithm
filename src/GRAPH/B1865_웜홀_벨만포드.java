package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class B1865_��Ȧ_�������� {
 
	// ��Ȧ�� ��ȯ�� �ϴ��� ���ϴ����� ���� ����
		public static void main(String args[]) throws NumberFormatException, IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			for(int test_case =0; test_case<T; test_case++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				ArrayList <edge> listA =  new ArrayList <edge>();
				int dist[];
				int N = Integer.parseInt(st.nextToken()); // ������ ���� (1��N��500)
				int M = Integer.parseInt(st.nextToken()); // ������ ���� (1��M��2500)
				int W = Integer.parseInt(st.nextToken()); // ��Ȧ�� ���� (1��W��200)
				
				dist = new int [N+1];
				
				for(int i=0; i<M; i++){ //���ΰ� ����
					st = new StringTokenizer(br.readLine());
					int S = Integer.parseInt(st.nextToken()); // ��������
					int E = Integer.parseInt(st.nextToken()); // ��������
					int D = Integer.parseInt(st.nextToken()); // �ð�
					listA.add(new edge(S,E,D));
					listA.add(new edge(E,S,D));
				}
				
				for(int i=0; i<W; i++){ //������ ����
					st = new StringTokenizer(br.readLine());
					int S = Integer.parseInt(st.nextToken()); // ��������
					int E = Integer.parseInt(st.nextToken()); // ��������
					int D = Integer.parseInt(st.nextToken()); // �ð�
					listA.add(new edge(S,E,(D*-1)));
				}
				
				for(int i=0; i<N+1; i++){ //dist�� �ʱ�ȭ�� ����
					dist[i]=Integer.MAX_VALUE;
				}
				dist[1]=0;
				
				if(bellmanford(dist,listA,N,M)){
					System.out.println("NO");
				}else{
					System.out.println("YES");
				}
			}
		}
		static boolean bellmanford(int []dist, ArrayList <edge> listA, int N, int M){
			//V-1�� ��ŭ �ݺ��Ѵ�.
			for(int i=0; i<N-1; i++){
				for(int j=0; j<listA.size(); j++){
					//��ȭ ���� ���� Relaxation
					//upper[a]<=upper[s]+w(s,a) ������ �ݺ��ؼ� ����
					int s = listA.get(j).getStart();
					int e = listA.get(j).getEnd();
					int t = listA.get(j).getTime();
					if (dist[s] == Integer.MAX_VALUE)
	                     continue;
					if(dist[e]>dist[s]+t){
						dist[e]=dist[s]+t;
					}
				}
			}
			
			//����Ŭ ��ȯ Ȯ��
			for(int j=0; j<listA.size(); j++){
				int s = listA.get(j).getStart();
				int e = listA.get(j).getEnd();
				int t = listA.get(j).getTime();
				if(dist[e]>dist[s]+t){
					return false;
				}
			}
			return true;
		}
	}

	class edge{
		int start;
		int end;
		int time;
		public edge(int start, int end, int time){
			this.start = start;
			this.end = end;
			this.time = time;
		}
		public int getStart(){
			return start;
		}
		public int getEnd(){
			return end;
		}
		public int getTime(){
			return time;
		}
	}
     