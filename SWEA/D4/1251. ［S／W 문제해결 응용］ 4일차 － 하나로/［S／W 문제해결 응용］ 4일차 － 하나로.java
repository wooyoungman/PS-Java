
import java.util.*;
import java.io.*;
public class Solution {

	static int[] par;
	static int N;
	static double E;
	static int []pos_x;
	static int []pos_y;
	//static long [][]length;
	static PriorityQueue<pEdge> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		for(int T=1;T<=t;T++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			par = new int[N+1];
			// 대표 노드 값 저장
			for(int i=1;i<=N;i++) {
				par[i]=i;
			}
			pos_x= new int[N+1];
			pos_y= new int[N+1];
			// x좌표 저장
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				pos_x[i] = Integer.parseInt(st.nextToken());
			}
			// y좌표 저장 
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				pos_y[i] = Integer.parseInt(st.nextToken());
			}
			// E값 저장
			st = new StringTokenizer(br.readLine());
			E=Double.parseDouble(st.nextToken());
			queue=new PriorityQueue<>();
			// 길이(가중치) 계산 및 큐에 넣기 
			for(int i=1;i<=N;i++) {
				for(int j=i+1;j<=N;j++) {
					
					// i = 출발 섬 번호, j = 도착 섬 번호, legnth = 두 섬 사이의 길이
					long length =  (long) Math.abs((Math.pow(pos_x[i] - pos_x[j],2) + Math.pow(pos_y[i]-pos_y[j],2)));
					queue.add(new pEdge(i,j,length));
				}
			}

			long useEdge = 0;
			long result = 0;
			while(useEdge < N-1) {
				pEdge now = queue.poll();
				// 같은 부모가 아니면 연결해도 괜찮음 (사이클이 생기지 않음)
				if(find(now.s)!=find(now.e)) {
					union(now.s,now.e);
					result += now.length;
					useEdge++;
				}
			}
			System.out.println("#"+T+" "+Math.round(result*E));
		}
		
		
	}
	private static void union(int a, int b) {
		// TODO Auto-generated method stub
		a=find(a);
		b=find(b);
		if(a!=b) {
			par[b]=a;
		}
	}
	public static int find(int a) {
		if(a==par[a]) {
			return a;
		}
		else {
			return par[a]=find(par[a]);
		}
	}
	static class pEdge implements Comparable<pEdge>{
		int s,e;
		long length;
		pEdge(int s, int e,long length){
			this.s=s;
			this.e=e;
			this.length=length;
		}
		@Override
		public int compareTo(pEdge o) {
			// 가중치를 기준으로 오름차순 정렬을 하기 위해 compare To 재정의
			return Long.compare(this.length,o.length);
		}
	}
	
}
