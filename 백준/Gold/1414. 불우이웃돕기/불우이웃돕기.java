
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] par;
	static PriorityQueue<pEdge> queue;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		par = new int[N+1];
		for(int i=1;i<=N;i++) {
			par[i]=i;
		}
		queue = new PriorityQueue<>();
		int total_l=0;
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			for(int j=1;j<=N;j++) {
				char temp = str.charAt(j-1);
				if(temp=='0') {
					continue;
				}
				else
				{
					// 대문자 알파벳인 경우
					if(temp>=65&&temp<=90) {
						queue.add(new pEdge(i,j,temp-'A'+27));
						total_l+=temp-'A'+27;
					}
					// 소문자 알파벳인 경우
					else
					{
						queue.add(new pEdge(i,j,temp-'a'+1));
						total_l+=temp-'a'+1;
					}
					
				}
			}
		}
		
		int useEdge = 0;
		int result = 0;
		boolean check = false;
		while(useEdge < N-1 && !queue.isEmpty()) {
		 
			pEdge now = queue.poll();
			// 같은 부모가 아닐 때만 연결하기
			if(find(now.s)!=find(now.e)) {
				union(now.s,now.e);
				result+=now.v;
				useEdge++;
				check=true;
			}


		}
		if(useEdge==N-1) {
			System.out.println(total_l-result);
		}
		else
		{
			System.out.println(-1);
		}
	}
	
	public static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			par[b]=a;
		}
	}
	
	
	
	public static int find(int a) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
			return this.v-o.v;
		}
	}
}
