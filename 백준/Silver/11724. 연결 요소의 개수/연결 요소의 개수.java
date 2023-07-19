
import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static ArrayList<Integer>[] arr;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N과 M 입력 받기 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		visited = new boolean[N+1];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
						
		}
		
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			
			// 방문하지 않은 노드가 있으면 dfs 실행 및 실행 횟수 +1 -> 총 실행 횟수가 연결 요소의 개수임
			if(!visited[i])
			{
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int i) {
		// TODO Auto-generated method stub
		
		if(visited[i]) {
			return;
		}
		visited[i]=true;
		for(int a:arr[i]) {
			if(!visited[a]) {
				dfs(a);
			}
		}
	}
	

}
