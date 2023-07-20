
import java.util.*;
import java.io.*;
public class Main {

	static int[] par;
	static int N,M;
	static PriorityQueue<pEdge> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		queue=new PriorityQueue<>();
		par = new int[N+1];
		// 대표 노드 값 저장
		for(int i=1;i<=N;i++) {
			par[i]=i;
		}

		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			queue.add(new pEdge(s,e,v));
		}
		
		int useEdge = 0;
		int result = 0;
		while(useEdge < N-1) {
			pEdge now = queue.poll();
			// 같은 부모가 아니면 연결해도 괜찮음 (사이클이 생기지 않음)
			if(find(now.s)!=find(now.e)) {
				union(now.s,now.e);
				result += now.v;
				useEdge++;
			}
		}
		System.out.println(result);
		
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
		int s,e,v;
		pEdge(int s,int e,int v){
			this.s=s;
			this.e=e;
			this.v=v;
		}
		@Override
		public int compareTo(pEdge o) {
			// 가중치를 기준으로 오름차순 정렬을 하기 위해 compare To 재정의
			return this.v-o.v;
		}
	}
	
}
