
import java.util.*;
import java.io.*;
public class Main {

	static int[] par;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		par = new int[N+1];
		for (int i=1; i <= N; i++)
		{
			par[i]=i;
		}
		
		// 도시 연결 데이터 저장하기 (0 1 0) (1 0 1) ...
		int [][] dosi = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				dosi[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 여행 계획 루트 저장하기
		int [] route = new int [M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++) {
			route[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(dosi[i][j]==1) {
					union(i,j);
				}
			}
		}
		
		
		// 여행 계획 도시들이 1개의 대표 도시로 연결 돼 있는지 확인하기
		int idx=find(route[1]);
		for(int i=2;i<route.length;i++) {
			if(idx!=find(route[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	public static void union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			par[b]=a;
		}
	}
	
	public static int find(int a) {
		if(a==par[a]) {
			return a;
		}
		else
		{
			return par[a]=find(par[a]);
		}
	}
	
}
